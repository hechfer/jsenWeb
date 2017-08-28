var inactividadJs = {
	inactividad : null,
	mostrar : true,
	
	/**
	 * Carga el modal de inactividad al inicio con una espera de 60 min
	 */
	inicio : function() {
		// Evento cada vez que se muestra el modal. la opcion mostrar se queda en false, para que no haya
		// problemas de doble modal. Solo se mostrara una vez.
		$('#modalInactividad').on('shown.bs.modal', function() {
			inactividadJs.mostrar = false;
		});
		
		// Evento para muestre el modal
		$('#modalInactividad').on('hidden.bs.modal', function() {
			inactividadJs.mostrar = true;
		});
	},
	
	/**
	 * Crea el modal de inactividad con nuevos 60min cada vez que encuentra actividad,
	 * se remueve el ultimo time out.
	 */
	parar : function(context) {
		clearTimeout(inactividadJs.inactividad);
		if(inactividadJs.mostrar){
			inactividadJs.inactividad = setTimeout(
				function(){
					inactividadJs.mostrarModal(context);
				},3600000); // 1 hora
		}
	},
	
	/**
	 * Muestra el modal y el progress bar.
	 */
	mostrarModal : function(context){
		//Muestra modal
		$("#modalInactividad").modal();
							
		// Barra con 10 segundos.
		var elem = document.getElementById("myBar"); 
	    var width = 1;
	    var contador = 0;
	    
	    var interval = setInterval(frame, 1000);
	    function frame() {
	    	
	        if (width >= 100) {
	        	clearInterval(interval);
	        	window.location.href = context+"/logout";
	        } else {
	        	width=width + 10; 
	            elem.style.width = width + '%'; 
	            elem.innerHTML = (++contador)+" Segundo(s)" ;
	        }
	    }
	    
	    // Limpia el timeout
	    $( "#botonCancelar" ).click(function() {
	    	clearInterval(interval);
		});
	}
	
}