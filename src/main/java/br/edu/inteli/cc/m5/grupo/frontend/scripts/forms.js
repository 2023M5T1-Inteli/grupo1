var next = document.getElementById("next");
var step_one = document.getElementById("1");
var step_two = document.getElementById("2");
var alert = document.getElementById("alert");


var send_btn = document.getElementById("send");
var confirm_btn = document.getElementById("confirm")
let url = "http://localhost:8080";
  



  confirm_btn.addEventListener('click', function(event){
    location.reload();
  });

  send_btn.addEventListener('click', function(event){
    var rows = document.getElementById("rows");
    var columns = document.getElementById("columns");
    var initial_lat = document.getElementById("initial_lat");
    var initial_long = document.getElementById("initial_long");


    event.preventDefault(); 
    alert.style.margin = "0vh 0 0 0";
    $.ajax({
      type: "POST",
      url: url,
      contentType: "application/json; charset=utf-8",
      dataType: "json",
      data: JSON.stringify({
        rows: rows,
        cols: columns,
        coordZero: {lat: initial_lat, longi: initial_long}
      }),
      success: function (res) {
        window.location.reload();
        console.log(res);
      },
    });
  

  });

  function netx_step(){
    step_one.style.display = "none";
    next.style.display = "none";
    step_two.style.display = "block";
  };

  