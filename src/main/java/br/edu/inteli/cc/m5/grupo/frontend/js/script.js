// map variable
var idMap = document.getElementById("my_dataviz");


// request endpoint
const url = "http://127.0.0.1:8080/graph/";


const handleForm = () => {

    const form = document.querySelector('.form-container');
    const pathForm = document.querySelector('#path-form');

    form.style.display = 'none';
    pathForm.style.display = 'flex';

}

const postGraph = async () => {

    // const longZero = parseFloat(document.querySelector('#min-long').value);
    // const latZero = parseFloat(document.querySelector('#min-lat').value);
    // const finalLat = parseFloat(document.querySelector('#final-lat').value);
    // const finalLong = parseFloat(document.querySelector('#final-long').value);
    // const pathLatX = parseFloat(document.querySelector('#path-lat-x').value)
    // const pathLongX = parseFloat(document.querySelector('#path-long-x').value)
    // const pathLatY = parseFloat(document.querySelector('#path-lat-y').value)
    // const pathLongY = parseFloat(document.querySelector('#path-long-y').value)
    const longZero = -22.5889042043;
    const latZero = -43.4855748;
    const finalLat = -22.359194448201;
    const finalLong = -42.5794347619519;
    const pathLatX = -22.5889042043;
    const pathLongX = -43.4855748;
    const pathLongY = -43.5573428666663;
    const pathLatY = -23.0696792891117;

    console.log(`
    longZero: ${longZero},
    latZero: ${latZero},
    finalLat: ${finalLat},
    finalLong: ${finalLong},
    pathLatX: ${pathLatX},
    pathLongX: ${pathLongX},
    pathLatY: ${pathLatY}
    pathLongY: ${pathLongY}
    `)

    myMap.setView([latZero, longZero], 15);

    const requestSettings = {
        method: 'POST',
        headers: {
            'Content-type': 'application/json'
        },
        body: JSON.stringify({
            longZero: longZero,
            latZero: latZero,    
            finalLat: finalLat,
            finalLong: finalLong
        })
    }

    const loading = document.querySelector('.loading-container');
    loading.style.display = 'flex';

    fetch(url, requestSettings).
    then(response => response.json()).
    then(data => {
        setTimeout(() => {loading.style.display = 'none';}, 500);
        createSvg(data)
    }).
    catch(err => {
        loading.style.display = 'none';
        console.error(err);
    })

}



var myMap = L.map(idMap).setView([-22.5889042043, -43.4855748], 8);
    L.tileLayer("https://server.arcgisonline.com/ArcGIS/rest/services/World_Imagery/MapServer/tile/{z}/{y}/{x}", {
    maxZoom: 18,
    }).addTo(myMap);


    myMap.on("click", function(e) {

        var lat = e.latlng.lat.toFixed(15);
        var lng = e.latlng.lng.toFixed(15);
        L.popup()
        .setLatLng(e.latlng)
        .setContent("Latitude: " + lat + "<br>Longitude: " + lng)
        .openOn(myMap);
    });



const createSvg = (data) => {

    console.log(data)

    for (i = 0; i != data.length; i++){
        // create the initial points and the others
        if (i != data.length - 1) {
            var circle = L.circle([data[i].latitude, data[i].longitude], {
                radius: 50,
                color: i == 0 ? "#41aa61" : "rgba(0,0,0,0)",
                fillColor: i == 0 ? "#41aa61" : "rgba(0,0,0,0)",
                fillOpacity: 0.5
            }).addTo(myMap);
        }
        console.log(data.length - 1)
        console.log(i)
        console.log(`latitude ${data[i].latitude}`)
        console.log(`longitude ${data[i].longitude}`)

        // create the final point
        if (i == data.length - 1) {
            
            var circle = L.circle([data[i].latitude, data[i].longitude], {
                radius: 50,
                color:  "#d12ef3",
                fillColor: "#d12ef3",
                fillOpacity: 0.5
            }).addTo(myMap);
        }

        // create the edges
        if (i < data.length - 1) {

            var pointA = new L.LatLng(data[i].latitude, data[i].longitude);
            var pointB = new L.LatLng(data[i + 1].latitude, data[i + 1].longitude);
            var linePoints = [pointA, pointB];
            var polyline = L.polyline(linePoints, {color: '#FFD600'}).addTo(myMap);
        }
    }
}