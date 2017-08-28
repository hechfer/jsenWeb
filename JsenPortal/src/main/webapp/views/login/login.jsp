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

<!-- JQUERY -->
<script src="https://code.jquery.com/jquery-1.11.3.min.js" integrity="sha256-7LkWEzqTdpEfELxcZZlS6wAx5Ff13zZ83lYO2/ujj7g=" crossorigin="anonymous"></script>

<!-- BOOTSTRAP -->
<script type="text/javascript" src="<%=request.getContextPath()%>/static/tether/js/tether.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/bootstrap/js/bootstrap.min.js"></script>

<!-- ESTILOS BOOTSTRAP Y PROPIOS DE LA PÁGINA -->
<link type="text/css" href="<%=request.getContextPath()%>/static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/static/css/login.css" type="text/css" rel="stylesheet">
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="containerCentro col-sm-6 col-md-4 col-md-offset-4">
				<div class="account-wall">
					<h1 class="text-center login-title"><strong>Identificate</strong></h1>
					<form class="form-signin" action="<%=request.getContextPath()%>/login" method="post">
						<input type="text" class="form-control" placeholder="Usuario..."
							required autofocus name="username"> <input type="password" name="password"
							class="form-control" placeholder="Contrase&ntilde;a..." required>
						<button class="btn btn-ms btn-success btn-block" type="submit">Login</button>
						<a href="#" class="pull-right need-help">¿Olvidaste tu contrase&ntilde;a? </a><span
							class="clearfix"></span>
						<br><br>
						<p class="text-center">¿Quieres unirte a Jsen?</p>
						<button class="btn btn-ms btn-info btn-block" type="button" 
							onclick ="location='<%=request.getContextPath()%>/registroUsuario'">
							Comenzar Registro
						</button>
						<br>
						<!-- Mensajes en caso de que salga algo mal -->
						<c:if test="${param.reason eq 'sessionExpired'}">
							<div class="reason">
								<p class="text-center">Tienes 10 sesi&oacute;n activas</p>								
							</div>								
						</c:if>
						<c:if test="${param.reason eq 'invalidSession'}">
							<div class="reason">
								<p class="text-center">Sesi&oacute;n Inv&aacute;lida</p>
							</div>
						</c:if>
						<c:if test="${not empty param.error}">
							<div class="error">Usuario y Contrase&ntilde;a invalidos</div>
						</c:if>
						<c:if test="${param.reason eq 'sessionClosed'}">
							<div class="reason">
								<p class="text-center">Se ha cerrado su sesi&oacute;n</p>
							</div>
						</c:if>
					</form>					
				</div>				
			</div>
		</div>
	</div>
</body>
</html>