const url = "http://127.0.0.1:8080/graph/";


const handleForm = () => {

    const form = document.querySelector('.form-container');
    const pathForm = document.querySelector('#path-form');

    form.style.display = 'none';
    pathForm.style.display = 'flex';

}

const postGraph = async () => {

    const longZero = parseFloat(document.querySelector('#min-lat').value);
    const latZero = parseFloat(document.querySelector('#min-long').value);
    const rows = parseFloat(document.querySelector('#rows').value);
    const cols = parseFloat(document.querySelector('#cols').value);

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

const createSvg = (data) => {

    console.log(data);

    // configura as dimensões e parâmetros gerais do SVG
    var margin = {top: 10, right: 300, bottom: 30, left: 400},
    width = 1456,
    height = 800,
    scale = 1, // zoom
    translateX = width/2, // translação horizontal
    translateY = height/2; // translação vertical


    // monta o svg que receberá o desenho do grafo
    var svg = d3.select(".leaflet-pane_Virtual_0-pane")
            .append("svg")
            .attr("width", width)
            .attr("height", height)
            .style("z-index", "9999999999999999")
            .append("g");
            

    // var link = svg
    // .selectAll("line")
    // .data(data)
    // .enter()
    // .append("line")
    //     .style("stroke", "#333")
       
    //     .attr("y1",function(d) {return d.latitude*scale*-1 + translateY})
    //     .attr("x1",function(d) {return d.longitude*scale + translateX})
    //     .attr("y2",function(d, i) {
    //         if (i < data.length-1) {
    //             return data[i+1].latitude*scale*-1 + translateY
    //         } 
    //         })
    //     .attr("x2",function(d, i) {
    //         if (i < data.length - 1) {
    //             return data[i+1].longitude*scale + translateX}
    //         })

    //para cada nó, desenha um círculo
    var nodes = svg
    .selectAll("circle")
    .data(data)
    .enter()
    .append("circle")
        .style("fill", function(d, i){
        // atribuir cor ao nó inicial
        if (i == 0){
        return "#41aa61"
        }
        // atribuir cor ao nó final
        else if (i == data.length-1){
            return "#d12ef3"
        }
        // atribuir cor aos nós intermediários
        return "#FFD600";
        })
        .attr("r", function(d, i){
            if (i == 0){
                return 4
            }
            // atribuir cor ao nó final
            else if (i == data.length-1){
                return 4
            }
            // atribuir cor aos nós intermediários
            return 2
        }) // o raio do círculo dos nós
        .attr("cx",function(d, i) {console.log(d); return d.longitude*scale + translateX + (i/5)})
        .attr("cy",function(d, i) {return d.latitude*scale*-1 + translateY + (i/5)});
    

}

