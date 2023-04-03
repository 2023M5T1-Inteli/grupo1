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



var myMap = L.map(idMap).setView([-22.5889042043, -43.4855748], 13);
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

    console.log(data);
    for (i in data){
        var circle = L.circle([data[i].latitude, data[i].longitude], {
            radius: 100,
            color: 'blue',
            fillColor: '#f03',
            fillOpacity: 0.5
        }).addTo(myMap);
    }

    // for (i in data){
    //     if (i < data.lenght - 2) {

    //         var edge = L.polyline([[data[i].latitude, data[i].longitude], [data[i+1].latitude, data[i+1].longitude]], {
    //             color: 'yellow',
    //             weight: 3,
    //             opacity: 0.5
    //         }).addTo(myMap);
    //     }
    // }

}