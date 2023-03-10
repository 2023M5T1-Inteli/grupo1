// seleção da malha (área do svg)
var svg = d3.select("#mesh");
var create = d3.select("#create");
// se o botão de envio for clicado, as propriedades linha e coluna inputadas são selecionadas
d3.json("url_do_backend").then(function(data) {
  // atribui a largura do svg
  
    // seleciona todos os círculos que ainda não existem
    svg.selectAll("circle")
    // seleciona todos os elementos círculos para cada dado
    .data(data.circles)
    .enter()
    .append("circle")
    // insere grid e a distância de cada ponto
    .attr("cx", function (d) { return d.x * 20 + 20; })
    .attr("cy", function (d) { return d.y * 20 + 20; })
    .attr("r", 5)
    .attr("fill", "orange");
});

create.on("click", function () {
    
  var line = +d3.select("#line").property("value");
  var columns = +d3.select("#columns").property("value");
  // retorna um array linha x coluna de acordo com os valores inputados
  var data = d3.range(line * columns);
    // seleciona todos os círculos que ainda não existem
    svg.selectAll("circle")
    // seleciona todos os elementos círculos para cada dado
    .data(data)
    .enter()
    .append("circle")
    // insere grid e a distância de cada
    .attr("cx", function (d, i) { return (i % columns) * 20 + 20; })
    .attr("cy", function (d, i) { return Math.floor(i / columns) * 20 + 20; })
    .attr("r", 5)
    .attr("fill", "orange");
});