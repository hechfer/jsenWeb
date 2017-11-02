var registroUsuarioJs = {
	// Campos obligatorios
	campos : [{
		id : "#correo",
		errorTxtEmail : "Ingresar un email valido",
		tipoValidacion : "email",
		obligatorio : "SI"
	},{
		id : "#password",
		idConf : "#confirm", //opcional
		errorTxtPass : "Deberian ser de 8 a 18 carcateres",
		errorTextInvalid : "Al menos un numero, Al menos una letra minuscula, Al menos una letra mayuscula, No espacios en Blanco, Al menos 1 caracter especial",
		tipoValidacion : "password",
		minChars : "8",
		obligatorio : "SI" // para el pass siempre sera SI
	},{
		id : "#confirm",
		idPass : "#password",
		errorTxtPassConf : "Deberian ser de 8 a 18 carcateres",
		erorTxtNotEqual : "No coincide la Contrase\u00F1a",
		tipoValidacion : "passwordConf",
		minChars : "8",
		obligatorio : "SI" // para el pass siempre sera SI
	}/*,{
		id : "#username",
		errorTxtCustom : "Deberian ser de 5 a 20 caracteres",
		minChars : "5",
		tipoValidacion : "texto",
		obligatorio : "SI"
	},*/,{
		id : "#numero",
		errorTxtCustom : "Deberian ser 10 digitos",
		minChars : "10",
		tipoValidacion : "numero",
		obligatorio : "SI"
	},{
		id : "#lada",
		tipoValidacion : "texto",
		obligatorio : "SI",
		errorTxtCustom : "",
		minChars : "1",
	}],
	
	init : function(){
		// tooltip y validacion de formulario
		validarCamposJs.crearEventos(registroUsuarioJs.campos);
		registroUsuarioJs.cargarDatos();
		// evanto para enviar el formulario y hacer alguna peticion ajax
		$('#enviarRegistro').click(function(){
			isValido = validarCamposJs.validarFormulario(registroUsuarioJs.campos);
			if(isValido){
				var json = registroUsuarioJs.jsonRegistrarUsuario();
				$.ajax({
					type: 'get',
					url: '/JsenPortal/registrarUsuario',
					data: json,
					contentType : "application/json",
					async: false,
					dataType : 'json',
					success: function(data) {
						if(data.status == "OK"){
							document.location.href = '/JsenPortal/registroUsuario?mensaje='+data.message;
						}else{
							document.location.href = '/JsenPortal/registroUsuario?mensajeError='+data.message;
						}
					},
					error: function(error) {
					}
				});
			}
		});
	},
	
	jsonRegistrarUsuario : function(){
		var json = {
			correo : $('#correo').val(),
			numero : $('#numero').val(),
			password : $('#password').val(),
			lada : $('#lada').val()
		};
		return json;
		
	},
	
	cargarDatos : function(){
		$.ajax({
			type: 'get',
			url: '/JsenPortal/consultarLada',
			contentType : "application/json",
			async: false,
			dataType : 'json',
			success: function(data) {
				if(data.status == "OK"){
					for(i = 0; i <data.responseBody.length; i++){
						 $("#lada").append('<option value='+data.responseBody[i].claveLocalidad+'>'+data.responseBody[i].claveLocalidad+' - '+data.responseBody[i].localidad+'</option>');
					}
				}
			},
			error: function(error) {
			}
		});
	}

}