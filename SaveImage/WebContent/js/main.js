  jQuery(function($){


    var jcrop_api;


    function initJcrop()
    {
      // Hide any interface elements that require Jcrop
      // (This is for the local user interface portion.)
      $('.requires').hide();

      // Invoke Jcrop in typical fashion
      $('#target').Jcrop({
//        onRelease: releaseCheck,
        onSelect: setCoordinates
      },function(){

        jcrop_api = this;
        //Posicionamos cuadro de seleccion inicial
        	//hay que llamar a setCoordenads para guardar el tamaño inicial del cuadro
        //jcrop_api.animateTo([10,10,100,100]);
      });

    };

    $('#enable').click(function(e) {
      //Inicializamos JCrop
      initJcrop();

      // Re-enable Jcrop instance
      jcrop_api.enable();

    });

function resetJCrop(){
      // Destroy Jcrop widget, restore original state
      jcrop_api.destroy();
}

 $("#botonFile").change(function (e) {
  //reseteamos JCrop
  if (jcrop_api !== undefined){
  resetJCrop();
}
  var input = event.target;
    var reader = new FileReader();
    reader.onload = function(){
      var dataURL = reader.result;
      var output = document.getElementById('target');
      output.src = dataURL;
      //Guardamos ruta imagen
      $("#idImgSRC").attr("value",dataURL);
      //Resetamos div de imagen para recoger nueva dimension
   		$("#target").css("width","");
   		$("#target").css("height",""); 
    };
    //mostramos boton recortar
    $(".requires").show();
  //mostramos caja imagen
    $("#target").show();
//    reader.readAsDataURL(input.files[0]); //Sentencia no compatible con IE10
    reader.readAsDataURL(document.getElementById("botonFile").files[0]);
  });

	function setCoordinates(c) {
		document.myForm.x.value = c.x;
		document.myForm.y.value = c.y;
		document.myForm.w.value = c.w;
		document.myForm.h.value = c.h;
	};
	

	//Permite hacer nuevas selecciones
    // $('#can_click').change(function(e) {
    //   jcrop_api.setOptions({ allowSelect: !!this.checked });
    //   jcrop_api.focus();
    // });
	
	//Permite mover el cuadro de seleccion
    // $('#can_move').change(function(e) {
    //   jcrop_api.setOptions({ allowMove: !!this.checked });
    //   jcrop_api.focus();
    // });
	
	//Permite poder redimensionar el cuadro de seleccion
    // $('#can_size').change(function(e) {
    //   jcrop_api.setOptions({ allowResize: !!this.checked });
    //   jcrop_api.focus();
    // });
	
	//Obliga a mantener un ratio en el cuadro de seleccion
    // $('#ar_lock').change(function(e) {
    //   jcrop_api.setOptions(this.checked?
    //     { aspectRatio: 4/3 }: { aspectRatio: 0 });
    //   jcrop_api.focus();
    // });
	
	//Obliga a tener un minimo/maximo en el cuadro de seleccion de recorte
    // $('#size_lock').change(function(e) {
    //   jcrop_api.setOptions(this.checked? {
    //     minSize: [ 80, 80 ],
    //     maxSize: [ 350, 350 ]
    //   }: {
    //     minSize: [ 0, 0 ],
    //     maxSize: [ 0, 0 ]
    //   });
    //   jcrop_api.focus();
    // });	
	
   });


function checkCoordinates() {
		if (document.myForm.x.value == "" || document.myForm.y.value == "") {
			alert("Por favor selecciona un área para recortar la imagen");
			return false;
		} else {
			return true;
		}
	};
	

	$(document).ready(function(){
		//ocultamos boton recortar
		$(".requires").hide();
		//ocultamos caja imagen
		$("#target").hide();
		
	});

