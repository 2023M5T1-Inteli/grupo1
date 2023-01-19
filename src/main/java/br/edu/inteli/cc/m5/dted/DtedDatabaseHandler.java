package br.edu.inteli.cc.m5.dted;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.gdal.gdal.gdal;
import org.gdal.gdal.Dataset;
import org.gdal.gdalconst.gdalconst;

/**
 * Implementa operações básicas de acesso a dados geográficos armazenados em arquivos
 * no formato DTED utilizando a biblioteca GDAL.
 */

public class DtedDatabaseHandler {

    public boolean InitializeFromResources(String pathInResources) {
        boolean retCode = false;

        // Get version (for debug purposes only)
        String s = gdal.VersionInfo();

        // Register GDAL
        gdal.AllRegister();

        try {
            ClassLoader classLoader = getClass().getClassLoader();

            URL resource = classLoader.getResource(pathInResources);

            // dun walk the root path, we will walk all the classes
            List<File> dtedFiles = Files.walk(Paths.get(resource.toURI()))
                    .filter(Files::isRegularFile)
                    .map(x -> x.toFile())
                    .collect(Collectors.toList());

            m_DatabaseDtedDatasets = new ArrayList<>();

            // Loop over all ".dt2" files to get their datasets
            for (File f: dtedFiles)
            {
                Dataset d = gdal.Open(f.getAbsolutePath());
                if(d != null)
                    m_DatabaseDtedDatasets.add(d);
            }

            retCode = true;
        } catch(URISyntaxException ex) {
            retCode = false;
        } catch(IOException ex) {
            retCode = false;
        } catch(NullPointerException ex) {
            retCode = false;
        }

        return retCode;
    }

    public boolean Initialize(String database_path) {
        boolean retCode = false;

        // Get version (for debug purposes only)
        String s = gdal.VersionInfo();

        // Register GDAL
        gdal.AllRegister();

        // Creating a file object to iterate over database directory
        File fileDatabasePath = new File(database_path);

        // Sanity check on database path
        if(fileDatabasePath.exists() && fileDatabasePath.isDirectory())
        {
            List<File> dtedFiles = new ArrayList<>();

            // Loop over all files to find ".dt2" files
            for (File f : fileDatabasePath.listFiles() )
            {
                if(f.isFile())
                {
                    Optional<String> extension = getExtensionByStringHandling(f.getName());
                    if(extension.isPresent())
                    {
                        if(extension.get().toLowerCase().contains("dt2"))
                        {
                            dtedFiles.add(f);
                        }
                    }
                }
            }

            m_DatabaseDtedDatasets = new ArrayList<>();

            // Loop over all ".dt2" files to get their datasets
            for (File f: dtedFiles)
            {
                Dataset d = gdal.Open(f.getAbsolutePath());
                if(d != null)
                    m_DatabaseDtedDatasets.add(d);
            }

            retCode = true;
        }

        return retCode;
    }

    public Optional<Integer> QueryLatLonElevation(Double queryLon, Double queryLat)
    {
        Optional<Integer> ret = null;

        for (Dataset d : m_DatabaseDtedDatasets)
        {
            if(isCoordinateInsideDataset(d, queryLon, queryLat))
            {
                ret = Optional.of(queryDataset(d, queryLon, queryLat));
                break;
            }
        }
        return ret;
    }

    private List<Dataset> m_DatabaseDtedDatasets;

    private static Optional<String> getExtensionByStringHandling(String filename)
    {
        return Optional.ofNullable(filename)
                .filter(f -> f.contains("."))
                .map(f -> f.substring(filename.lastIndexOf(".") + 1));
    }

    private static boolean isCoordinateInsideDataset(Dataset d, Double lon, Double lat)
    {
        boolean retCode = false;

        int xsize = d.getRasterXSize();
        int ysize = d.getRasterYSize();

        double[] geoTransform = d.GetGeoTransform();

        double minLon = geoTransform[0];
        double maxLon = minLon  + (xsize-1)*geoTransform[1];

        double maxLat = geoTransform[3];
        double minLat = maxLat + (ysize-1)*geoTransform[5];

        retCode = (maxLat > lat) && (minLat < lat) &&
                (maxLon > lon) && (minLon < lon);

        return retCode;
    }

    private static int queryDataset(Dataset d, Double lon, Double lat)
    {
        int xsize = d.getRasterXSize();
        int ysize = d.getRasterYSize();

        double[] geoTransform = d.GetGeoTransform();

        double minLon = geoTransform[0];
        double maxLon = minLon  + (xsize-1)*geoTransform[1];

        double maxLat = geoTransform[3];
        double minLat = maxLat + (ysize-1)*geoTransform[5];

        Double queryOffsetXDouble = ((lon - minLon))*(xsize-1);
        Double queryOffsetYDouble = ((maxLat - lat))*(ysize-1);

        int queryOffsetX = queryOffsetXDouble.intValue();
        int queryOffsetY = queryOffsetYDouble.intValue();

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(4 );
        byteBuffer.order(ByteOrder.nativeOrder());
        d.GetRasterBand(1).ReadRaster_Direct(queryOffsetX, queryOffsetY, 1, 1,1,1, gdalconst.GDT_Int32, byteBuffer );
        int queryResult = byteBuffer.getInt(0);

        return queryResult;
    }


}
