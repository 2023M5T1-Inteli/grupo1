let zoom = d3.zoom();

// configura as dimensões e parâmetros gerais do SVG
var margin = {top: 10, right: 300, bottom: 30, left: 400},
width = 800,
height = 500,
scale = 2, //modifique este valor para aumentar ou diminuir o zoom
translateX = width/2, //modifique este valor para translação horizontal
translateY = height/2; //modifique este valor para translação vertical


// monta o svg que receberá o desenho do grafo
var svg = d3.select("#my_dataviz")
        .append("svg")
          .attr("width", width)
          .attr("height", height)
          .append("g");



// carrega o arquivo json com informações dos nós e arestas
d3.json("./data/data.json").then(function(data) {
//para cada aresta, desenha uma linha
var link = svg
  .selectAll("line")
  .data(data.links)
  .enter()
  .append("line")
    .style("stroke", "#3E6D9C")
    .attr("y1",function(d) {return data.coordinates[d.start].lat*scale*-1 + translateY})
    .attr("x1",function(d) {return data.coordinates[d.start].long*scale + translateX})
    .attr("y2",function(d) {return data.coordinates[d.end].lat*scale*-1 + translateY})
    .attr("x2",function(d) {return data.coordinates[d.end].long*scale + translateX});



//para cada nó, desenha um círculo
var nodes = svg
  .selectAll("circle")
  .data(data.coordinates)
  .enter()
  .append("circle")
    .style("fill", "#E14D2A")
    .attr("r",3) //é possível atribuir o valor de altitude do nó para controlar o raio do círculo
    .attr("cx",function(d) {return d.long*scale + translateX})
    .attr("cy",function(d) {return (-d.lat)*scale + translateY});


});