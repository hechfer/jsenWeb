var validarCamposJs = {
	formularioValido : false,
	/**
	 * funcion que crea los eventos de los componentes
	 * @param objCampos
	 */
	crearEventos : function(objCampos){
		for(i = 0 ; i < objCampos.length ; i++){
			var obj = objCampos[i]; 
			
			if(obj.tipoValidacion == 'email'){
				validarCamposJs.campoCorreo(obj.id, obj.errorTxtEmail, obj.obligatorio);
			}else if(obj.tipoValidacion == 'password'){
				validarCamposJs.campoPassword(obj.id, obj.errorTxtPass, obj.minChars, obj.idConf, obj.errorTextInvalid);
			}else if(obj.tipoValidacion == 'passwordConf'){
				validarCamposJs.campoConfirmPassword(obj.id, obj.idPass, obj.errorTxtPassConf, obj.erorTxtNotEqual,obj.minChars);
			}else if(obj.tipoValidacion == 'texto'){
				validarCamposJs.campoTexto(obj.id, obj.errorTxtCustom, obj.minChars, obj.obligatorio);
			}else if(obj.tipoValidacion == 'numero'){
				validarCamposJs.campoNumero(obj.id, obj.errorTxtNumeric, obj.minChars, obj.obligatorio);
			}
		}
	},
	
	/**
	 * funcion que sirve para validar una caja de texto tipo correo
	 * @param emailID (id del campo a validar)
	 * @param errorTextEmail (error que se va a mostrar)
	 * */
	campoCorreo : function(emailID, errorTextEmail, obligatorio){
		// Evento para la caja de texto tipo correo.
		$(emailID).keyup(function(){
			validarCamposJs.validarCorreo(emailID, errorTextEmail, obligatorio);
		});
	},
	
	/**
	 * funcion que sirve para validar una caja de texto tipo password
	 * @param passwordID (id del campo a validar)
	 * @param errorTextPassword (error que se va a mostrar)
	 * @param minCharsPass (minimo de caracteres)
	 * @param passConfId (id del campo de confirmacion de password, si es que hay)
	 * */
	campoPassword : function(passwordID, errorTextPassword, minCharsPass, passConfID, errorTextInvalid){
		// Evento para validar cajas de texto tipo password
	    $(passwordID).keyup(function(e){
	    	validarCamposJs.validarPassword(passwordID, errorTextPassword, minCharsPass, passConfID, errorTextInvalid);
	    });
	},
	
	/**
	 * funcion que sirve para validar una caja de texto tipo password
	 * @param passwordID (id del campo a validar)
	 * @param errorTextPassword (error que se va a mostrar)
	 * @param minCharsPass (minimo de caracteres)
	 * */
	campoConfirmPassword : function(passConfID, passwordID,
			errorTextPassword, errorTextNotEqualPass, minCharsPass){
		// Evento para validar cajas de texto tipo password
	    $(passConfID).keyup(function(){
	    	validarCamposJs.validarConfPass(passConfID, passwordID, 
	    			errorTextPassword, errorTextNotEqualPass, minCharsPass);
	    });
	},
	
	/**
	 * funcion que sirve para validar una caja de texto
	 * @param custom (id del campo a validar)
	 * @param errorTextCustom (error que se va a mostrar)
	 * @param minCharsCustom (minimo de caracteres)
	 * */
	campoTexto : function(customID, errorTextCustom, minCharsCustom, obligatorio){
	    // Evento para validar cualquier caja de texto con determinado numero de caracteres.
		$(customID).keyup(function(){
			validarCamposJs.validarTexto(customID, errorTextCustom, minCharsCustom, obligatorio);
		});
	},
	
	/**
	 * funcion que sirve para validar una caja de numeros
	 * @param numericID (id del campo a validar)
	 * @param errorTextNumeric (error que se va a mostrar)
	 * @param minCharsNumeric (minimo de numeros)
	 * */
	campoNumero : function(numericID, errorTextNumeric, minCharsNumeric, obligatorio){
	    // Evento para validar cualquier caja de texto con determinado numero de caracteres.
		$(numericID).keyup(function(){
			validarCamposJs.validarNumeros(numericID, errorTextNumeric, minCharsNumeric, obligatorio);
		});
	},

	/**
	 * funcion que sirve para validar el formato del correo
	 * @param emailAddress (valida el texto para ver si es un email)
	 * */
	isValidEmailAddress: function (emailAddress) {
		var pattern = new RegExp(/^(("[\w-\s]+")|([\w-]+(?:\.[\w-]+)*)|("[\w-\s]+")([\w-]+(?:\.[\w-]+)*))(@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$)|(@\[?((25[0-5]\.|2[0-4][0-9]\.|1[0-9]{2}\.|[0-9]{1,2}\.))((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\.){2}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\]?$)/i);
		return pattern.test(emailAddress);
	},
	
	/**
	 * funcion que sirve para validar el formato del PASSWORD
	 * Al menos una letra mayúscula
	 * Al menos una letra minucula
	 * Al menos un dígito
	 * No espacios en blanco
	 * Al menos 1 caracter especial
	 * @param password (valida el texto para ver si es una contrseña valida)
	 * */
	isValidPassword: function (password) {
		var pattern = new RegExp(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&]/);
		return pattern.test(password);
	},
	
	/**
	 * funcion que valida el campo correo.
	 */
	validarCorreo : function(emailID, errorTextEmail, obligatorio){
		var email = $.trim($(emailID).val());
		var txtEmail = emailID.substring(1, emailID.length);
	    if(email != 0) {
	    	if(validarCamposJs.isValidEmailAddress(email)){
	    		$(emailID).parents('.form-group').addClass('has-success');
	    		$('.form-control').addClass('form-control-success');
	    		$(emailID).parents('.form-group').removeClass('has-danger');
	    		$('.form-control').removeClass('form-control-danger');		    		
	    		$('.has-success').find('.text-'+txtEmail).css('display', 'none');
	    		validarCamposJs.formularioValido = true;
	    	} else {
	    		$('.form-control').removeClass('form-control-success');
	            $(emailID).parents('.form-group').removeClass('has-success');
	            
	    		$(emailID).parents('.form-group').addClass('has-danger');
	    		$('.form-control').addClass('form-control-danger');
	    		$('.has-danger').find('.text-'+txtEmail).text(errorTextEmail);
	    		$('.has-danger').find('.text-'+txtEmail).css('display', 'block');
	    		validarCamposJs.formularioValido = false;
			}
		} else {
			if(obligatorio == 'SI'){
				$('.form-control').removeClass('form-control-success');
	            $(emailID).parents('.form-group').removeClass('has-success');
	            
				$(emailID).parents('.form-group').addClass('has-danger');
				$('.form-control').addClass('form-control-danger');
				$('.has-danger').find('.text-'+txtEmail).text(errorTextEmail);
				$('.has-danger').find('.text-'+txtEmail).css('display', 'block');
				validarCamposJs.formularioValido = false;
			}else{
				validarCamposJs.resetComponenteInvalido(emailID);
			}
		}
	},
	
	/**
	 * funcion que valida el campo password
	 */
	validarPassword : function(passwordID, errorTextPassword, minCharsPass, passConfID, errorTextInvalid){
		var password = $.trim($(passwordID).val()).length * 1;
    	var txtPass = passwordID.substring(1, passwordID.length);
	    if(password > Math.round(minCharsPass - 1)) {
	    	if(validarCamposJs.isValidPassword($(passwordID).val())){
		    	$(passwordID).parents('.form-group').addClass('has-success');
	            $('.form-control').addClass('form-control-success');
	            $(passwordID).parents('.form-group').removeClass('has-danger');
	            $('.form-control').removeClass('form-control-danger');
				$('.has-success').find('.text-'+txtPass).css('display', 'none');
				validarCamposJs.formularioValido = true;
	    	}else{
	    		$('.form-control').removeClass('form-control-success');
		        $(passwordID).parents('.form-group').removeClass('has-success');
		        
		        $(passwordID).parents('.form-group').addClass('has-danger');
		        $('.form-control').addClass('form-control-danger');
				$('.has-danger').find('.text-'+txtPass).text(errorTextInvalid);
		 		$('.has-danger').find('.text-'+txtPass).css('display', 'block');
		 		validarCamposJs.formularioValido = false;
	    	}
	    } else if(password < minCharsPass){
	    	$('.form-control').removeClass('form-control-success');
	        $(passwordID).parents('.form-group').removeClass('has-success');
	        
	        $(passwordID).parents('.form-group').addClass('has-danger');
	        $('.form-control').addClass('form-control-danger');
			$('.has-danger').find('.text-'+txtPass).text(errorTextPassword);
	 		$('.has-danger').find('.text-'+txtPass).css('display', 'block');
	 		validarCamposJs.formularioValido = false;
    	}
	    
	    // Reset pass confirmar
	    if(passConfID != '' && passConfID != null && passConfID != undefined){
	    	var passConf = ($(passConfID).val() != undefined && $(passConfID).val() != null) ? 
	    			$(passConfID).val() : "";
	    	var pass = $(passwordID).val();
	    	
	    	if(pass != passConf || pass == "" || passConf == ""){
		    	var txtPass = passConfID.substring(1, passConfID.length);
		    	$(passConfID).val("");
		    	$(passConfID).parents('.form-group').removeClass('has-success');
	            $('.form-control').removeClass('form-control-success');
	            validarCamposJs.formularioValido = false;
	    	}else{
	    		var txtPass = passConfID.substring(1, passConfID.length);
	    		$(passConfID).parents('.form-group').addClass('has-success');
	            $('.form-control').addClass('form-control-success');
	            $(passConfID).parents('.form-group').removeClass('has-danger');
	            $('.form-control').removeClass('form-control-danger');
				$('.has-success').find('.text-'+txtPass).css('display', 'none');
				validarCamposJs.formularioValido = true;
	    	}
	    }
	},
	
	/**
	 * funcion que valida el campo confirmar password
	 */
	validarConfPass : function (passConfID, passwordID, 
			errorTextPassword, errorTextNotEqualPass, minCharsPass){
		var password = $.trim($(passConfID).val()).length * 1;
    	var txtPass = passConfID.substring(1, passConfID.length);
	    if(password > Math.round(minCharsPass - 1)) {
	    	var passwordOrig = $(passwordID).val();
	    	var passwordConf = $(passConfID).val();
	    	if(passwordOrig.toString() == passwordConf.toString()){
		    	$(passConfID).parents('.form-group').addClass('has-success');
	            $('.form-control').addClass('form-control-success');
	            $(passConfID).parents('.form-group').removeClass('has-danger');
	            $('.form-control').removeClass('form-control-danger');
				$('.has-success').find('.text-'+txtPass).css('display', 'none');
				validarCamposJs.formularioValido = true;
	    	}else{
	    		$('.form-control').removeClass('form-control-success');
	            $(passConfID).parents('.form-group').removeClass('has-success');
	            
	    		$(passConfID).parents('.form-group').addClass('has-danger');
	            $('.form-control').addClass('form-control-danger');
				$('.has-danger').find('.text-'+txtPass).text(errorTextNotEqualPass);
		 		$('.has-danger').find('.text-'+txtPass).css('display', 'block');
		 		validarCamposJs.formularioValido = false;
	    	}
	    } else if(password < minCharsPass){
	    	$('.form-control').removeClass('form-control-success');
            $(passConfID).parents('.form-group').removeClass('has-success');
            
            $(passConfID).parents('.form-group').addClass('has-danger');
            $('.form-control').addClass('form-control-danger');            
			$('.has-danger').find('.text-'+txtPass).text(errorTextPassword);
	 		$('.has-danger').find('.text-'+txtPass).css('display', 'block');
	 		validarCamposJs.formularioValido = false;
    	}
	},
	
	/**
	 * funcion que valida la longitud de un campo de texto
	 */
	validarTexto : function(customID, errorTextCustom, minCharsCustom, obligatorio){
		var custom = $.trim($(customID).val()).length * 1;
		var txtCustom = customID.substring(1, customID.length);
		if(custom > Math.round(minCharsCustom - 1)) {
			$(customID).parents('.form-group').addClass('has-success');
			$('.form-control').addClass('form-control-success');				
			$(customID).parents('.form-group').removeClass('has-danger');
			$('.form-control').removeClass('form-control-danger');
			$('.has-success').find('.text-'+txtCustom).css('display', 'none');
			validarCamposJs.formularioValido = true;
		} else if(custom < minCharsCustom){
			if(obligatorio == 'SI'){
				$('.form-control').removeClass('form-control-success');
	            $(customID).parents('.form-group').removeClass('has-success');
	            
				$(customID).parents('.form-group').addClass('has-danger');
				$('.form-control').addClass('form-control-danger');
				$('.has-danger').find('.text-'+txtCustom).text(errorTextCustom);
				$('.has-danger').find('.text-'+txtCustom).css('display', 'block');
				validarCamposJs.formularioValido = false;
			}else{
				if(custom == 0){
					validarCamposJs.resetComponenteInvalido(customID);
					validarCamposJs.formularioValido = true;
				}else{
					$('.form-control').removeClass('form-control-success');
		            $(customID).parents('.form-group').removeClass('has-success');
		            
					$(customID).parents('.form-group').addClass('has-danger');
					$('.form-control').addClass('form-control-danger');
					$('.has-danger').find('.text-'+txtCustom).text(errorTextCustom);
					$('.has-danger').find('.text-'+txtCustom).css('display', 'block');
					validarCamposJs.formularioValido = false;
				}
			}
			
		}
	},
	
	/**
	 * funcion que valida la longitud y solo numeros de un campo tipo numerico
	 */
	validarNumeros : function(numericID, errorTextNumeric, minCharsNumeric, obligatorio){
		$(numericID).val(($(numericID).val() + '').replace(/[^0-9]/g, ''));
		var numeros = $.trim($(numericID).val()).length * 1;
		var txtNumeros = numericID.substring(1, numericID.length);
		if(numeros > Math.round(minCharsNumeric - 1)) {
			$(numericID).parents('.form-group').addClass('has-success');
			$('.form-control').addClass('form-control-success');				
			$(numericID).parents('.form-group').removeClass('has-danger');
			$('.form-control').removeClass('form-control-danger');
			$('.has-success').find('.text-'+txtNumeros).css('display', 'none');
			validarCamposJs.formularioValido = true;
		} else if(numeros < minCharsNumeric){
			if(obligatorio == 'SI'){		
				$('.form-control').removeClass('form-control-success');
	            $(numericID).parents('.form-group').removeClass('has-success');
	            
				$(numericID).parents('.form-group').addClass('has-danger');
				$('.form-control').addClass('form-control-danger');
				$('.has-danger').find('.text-'+txtNumeros).text(errorTextNumeric);
				$('.has-danger').find('.text-'+txtNumeros).css('display', 'block');
				validarCamposJs.formularioValido = false;
			}else{
				if(numeros == 0){
					validarCamposJs.resetComponenteInvalido(numericID);
					validarCamposJs.formularioValido = true;
				}else{
					$('.form-control').removeClass('form-control-success');
		            $(numericID).parents('.form-group').removeClass('has-success');
		            
					$(numericID).parents('.form-group').addClass('has-danger');
					$('.form-control').addClass('form-control-danger');
					$('.has-danger').find('.text-'+txtNumeros).text(errorTextNumeric);
					$('.has-danger').find('.text-'+txtNumeros).css('display', 'block');
					validarCamposJs.formularioValido = false;
				}
			}
		}
	},
	
	/**
	 * funcion que valida todo el formulario
	 */
	validarFormulario : function(objCampos){
		var isValido = true;
		for(i = 0 ; i < objCampos.length ; i++){
			var obj = objCampos[i]; 
			// Campos Obligatorios.
			if(obj.tipoValidacion == 'email' && obj.obligatorio == 'SI'){
				validarCamposJs.validarCorreo(obj.id, obj.errorTxtEmail, obj.obligatorio);
				if(!validarCamposJs.formularioValido){
					isValido = false;
				}
			}else if(obj.tipoValidacion == 'password' && obj.obligatorio == 'SI'){
				validarCamposJs.validarPassword(obj.id, obj.errorTxtPass, obj.minChars, obj.idConf, obj.errorTextInvalid);
				if(!validarCamposJs.formularioValido){
					isValido = false;
				}
			}else if(obj.tipoValidacion == 'passwordConf' && obj.obligatorio == 'SI'){
				validarCamposJs.validarConfPass(obj.id, obj.idPass, obj.errorTxtPassConf, obj.erorTxtNotEqual, obj.minChars);
				if(!validarCamposJs.formularioValido){
					isValido = false;
				}
			}else if(obj.tipoValidacion == 'texto' && obj.obligatorio == 'SI'){
				validarCamposJs.validarTexto(obj.id, obj.errorTxtCustom, obj.minChars, obj.obligatorio);
				if(!validarCamposJs.formularioValido){
					isValido = false;
				}
			}else if(obj.tipoValidacion == 'numero' && obj.obligatorio == 'SI'){
				validarCamposJs.validarNumeros(obj.id, obj.errorTxtCustom, obj.minChars, obj.obligatorio);
				if(!validarCamposJs.formularioValido){
					isValido = false;
				}
			}
			
			// Campos opcionales.
			if(obj.tipoValidacion == 'email' && obj.obligatorio == 'NO'){
				validarCamposJs.validarCorreo(obj.id, obj.errorTxtEmail, obj.obligatorio);
				if(!validarCamposJs.formularioValido){
					validarCamposJs.resetComponenteInvalido(obj.id);
				}
			}else if(obj.tipoValidacion == 'texto' && obj.obligatorio == 'NO'){
				validarCamposJs.validarTexto(obj.id, obj.errorTxtCustom, obj.minChars, obj.obligatorio);
				if(!validarCamposJs.formularioValido){
					validarCamposJs.resetComponenteInvalido(obj.id);
				}
			}else if(obj.tipoValidacion == 'numero' && obj.obligatorio == 'NO'){
				validarCamposJs.validarNumeros(obj.id, obj.errorTxtCustom, obj.minChars, obj.obligatorio);
				if(!validarCamposJs.formularioValido){
					validarCamposJs.resetComponenteInvalido(obj.id);
				}
			}
		}
		
		return isValido;
	},
	
	resetComponenteInvalido : function(componenteID){
		var txtComponente = componenteID.substring(1, componenteID.length);
    	$(componenteID).val("");
    	$(componenteID).parents('.form-group').removeClass('has-success');
        $('.form-control').removeClass('form-control-success');
        $(componenteID).parents('.form-group').removeClass('has-danger');
        $('.form-control').removeClass('form-control-danger'); 
	}
}