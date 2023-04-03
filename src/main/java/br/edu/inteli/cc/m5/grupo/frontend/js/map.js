var idMap = document.getElementById("my_dataviz");
var sendBtn = document.getElementById("send-btn");

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

var circle = L.circle([-22.5889042043, -43.4855748], {
    radius: 100,
    color: 'blue',
    fillColor: '#f03',
    fillOpacity: 0.5
}).addTo(myMap);

var edge = L.polyline([[-22.5889042043, -43.4855748], [51.5, -0.1]], {
    color: 'yellow',
    weight: 3,
    opacity: 0.5
}).addTo(myMap);

sendBtn.addEventListener("click", function () {
    const longZero = parseFloat(document.querySelector('#min-long').value);
    const latZero = parseFloat(document.querySelector('#min-lat').value); 

    myMap.setView([latZero, longZero], 15);

})


