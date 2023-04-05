var idMap = document.getElementById("my_dataviz");
//var sendBtn = document.getElementById("send-btn");


const url = "http://127.0.0.1:8080/graph/";


const handleForm = () => {

    const form = document.querySelector('.form-container');
    const pathForm = document.querySelector('#path-form');

    form.style.display = 'none';
    pathForm.style.display = 'flex';

}

const postGraph = async () => {

    const longZero = parseFloat(document.querySelector('#min-long').value);
    const latZero = parseFloat(document.querySelector('#min-lat').value);
    const rows = parseInt(document.querySelector('#rows').value);
    const cols = parseInt(document.querySelector('#cols').value);

    myMap.setView([latZero, longZero], 15);

    const requestSettings = {
        method: 'POST',
        headers: {
            'Content-type': 'application/json'
        },
        body: JSON.stringify({
            longZero: longZero,
            latZero: latZero,    
            rows: rows,
            cols: cols
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

    for (i = 0; i != data.length; i++){
        // Cria os círculos intermediários e o inicial
        if (i != data.length - 1) {
            var circle = L.circle([data[i].latitude, data[i].longitude], {
                radius: 50,
                color: i == 0 ? "#41aa61" : "#FFD600",
                fillColor: "#FFD600",
                fillOpacity: 0.5
            }).addTo(myMap);
        }
        console.log(data.length - 1)
        console.log(i)
        console.log(`latitude ${data[i].latitude}`)
        console.log(`longitude ${data[i].longitude}`)

        // Cria o círculo final
        if (i == data.length - 1) {
            
            var circle = L.circle([data[i].latitude, data[i].longitude], {
                radius: 50,
                color:  "#d12ef3",
                fillColor: "#d12ef3",
                fillOpacity: 0.5
            }).addTo(myMap);
        }

        // Cria as arestas 
        if (i < data.length - 1) {

            var pointA = new L.LatLng(data[i].latitude, data[i].longitude);
            var pointB = new L.LatLng(data[i + 1].latitude, data[i + 1].longitude);
            var linePoints = [pointA, pointB];
            var polyline = L.polyline(linePoints, {color: '#FFD600'}).addTo(myMap);
        }
    }
}