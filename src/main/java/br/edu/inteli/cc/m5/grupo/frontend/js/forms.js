// botão next do forms
var next = document.getElementById("next");

// páginas do forms
var step_one = document.getElementById("1");
var step_two = document.getElementById("2");

// botão de enviar o forms
var send_btn = document.getElementById("send");

// alert de sucesso
var alert = document.getElementById("alert");
var confirm_btn = document.getElementById("confirm");



let url = "http://localhost:8080/graph/";

  // recarregar a página após clicar em confirmar no alert
  confirm_btn.addEventListener('click', function(event){
    location.reload();
  });

  
  send_btn.addEventListener('click', function(event){

    // armazenar informações dos inputs do forms
    var rows = document.getElementById("rows");
    var columns = document.getElementById("columns");
    var initial_lat = document.getElementById("initial_lat");
    var initial_long = document.getElementById("initial_long");

    var lat_ini = document.getElementById("lat_ini");
    var longi_ini = document.getElementById("longi_ini");
    var lat_final = document.getElementById("lat_final");
    var longi_final = document.getElementById("longi_final");

    console.log("RODOU");

    // enviar informações da criação da malha
    event.preventDefault(); 
    alert.style.margin = "0vh 0 0 0";
    $.ajax({
      type: "POST",
      url: url,
      contentType: "application/json;",
      dataType: "json",
      data: JSON.stringify({
        rows: parseInt(rows),
        cols: parseInt(columns),
        latZero: parseFloat(initial_lat),
        longiZero: parseFloat(initial_long)
      }),
      success: function (res) {
        console.log(res);
      },
    });


    // enviar informações do ponto inicial e final da rota
    $.ajax({
      type: "POST",
      url: url,
      contentType: "application/json; charset=utf-8",
      dataType: "json",
      data: JSON.stringify({
        origin: {
          lat: parseFloat(lat_ini),
          longi: parseFloat(longi_ini)
        },
        destiny: {
          lat: parseFloat(lat_final),
          longi: parseFloat(longi_final)
        }
      }),
      success: function (res) {
        window.location.reload();
        console.log(res);
      },
    });
  

  });

  // alterar a página do forms
  function netx_step(){
    step_one.style.display = "none";
    next.style.display = "none";
    step_two.style.display = "block";
  };

  
