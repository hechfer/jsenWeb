<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Jsen</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

<!-- ESTILOS BOOTSTRAP Y PROPIOS DE LA PÁGINA -->
<link type="text/css" href="<%=request.getContextPath()%>/static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- ESTILOS EN ICONOS -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/font-awesome/css/font-awesome.min.css">
<link href="<%=request.getContextPath()%>/static/css/registroUsuario.css" type="text/css" rel="stylesheet">

<!-- JQUERY -->
<script src="https://code.jquery.com/jquery-1.11.3.min.js" integrity="sha256-7LkWEzqTdpEfELxcZZlS6wAx5Ff13zZ83lYO2/ujj7g=" crossorigin="anonymous"></script>

<!-- BOOTSTRAP -->
<script type="text/javascript" src="<%=request.getContextPath()%>/static/tether/js/tether.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/bootstrap/js/bootstrap.min.js"></script>

<!-- Logica JS -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/util/validarCampos.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/registroUsuario/registroUsuario.js"></script>
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="containerCentro col-sm-6 col-md-4 col-md-offset-4">
				<div class="account-wall" padding='10px'>
					<h1 class="text-center registro-title"><strong>Registro</strong></h1>
					<form id="formRegistro" class="form-registro">
						<div class="form-group">
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="correo" id="correo"  placeholder="Ingresa tu Email"/>									
								</div>
								<small class="text-email"></small>
							</div>
						</div>

						<div class="form-group">
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="numero" id="numero"  placeholder="Ingresa N&uacute;mero Celuldar" maxLength = "20"/>									
								</div>
								<small class="text-numerosId"></small>
							</div>
						</div>
						
						<div class="form-group">
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<select class="form-control" name="lada" id="lada">
									</select>							
								</div>
								<small class="text-numerosId"></small>
							</div>
						</div>
						
						<!-- <div class="form-group">
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="numerosId" id="numerosId"  placeholder="Ingresa Numero de tarjeta" maxLength = "16"/>									
								</div>
								<small class="text-numerosId"></small>
							</div>
						</div>-->

						<div class="form-group">
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
									<input type="password" class="form-control" name="password" id="password"  placeholder="Ingresa tu Contrase&ntilde;a" maxLength = "18"/>									
								</div>
								<small class="text-password"></small>
							</div>
						</div>

						<div class="form-group">
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
									<input type="password" class="form-control" name="confirm" id="confirm"  placeholder="Confirma tu Contrase&ntilde;a" maxLength = "18"/>
								</div>
								<small class="text-confirm"></small>
							</div>
						</div>

						<div class="form-group ">
							<button class="btn btn-ms btn-success btn-block" type="button" id="enviarRegistro">Registrarme a Jsen</button>
						</div>
  						<!-- AGREGAR AVISO DE PRIVACIDAD -->
  						<p class="text-center letraTerminos">Al registrarme, declaro que soy mayor de edad y acepto las Políticas de privacidad y los Términos y condiciones de Jsen.</p>
  						<br>
  						<c:if test="${not empty param.mensajeError}">
							<div class="error">${param.mensajeError}</div>
						</c:if>
						<c:if test="${not empty param.mensaje}">
							<div class="exito"><p class="text-center">${param.mensaje}</p>
								<button class="btn btn-ms btn-info btn-block" type="button" 
									onclick ="location='<%=request.getContextPath()%>/login'">
									Iniciar Sesi&oacute;n
								</button>
							</div>
						</c:if>
					</form>					
				</div>				
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
registroUsuarioJs.init();
</script>
</html>