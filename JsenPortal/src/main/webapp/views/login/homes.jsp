<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

<!-- JQUERY -->
<script src="https://code.jquery.com/jquery-1.11.3.min.js" integrity="sha256-7LkWEzqTdpEfELxcZZlS6wAx5Ff13zZ83lYO2/ujj7g=" crossorigin="anonymous"></script>

<!-- BOOTSTRAP -->
<script type="text/javascript" src="<%=request.getContextPath()%>/static/tether/js/tether.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/bootstrap/js/bootstrap.min.js"></script>

<!-- ESTILOS BOOTSTRAP Y PROPIOS DE LA PÁGINA -->
<link type="text/css" href="<%=request.getContextPath()%>/static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/static/css/home.css" type="text/css" rel="stylesheet">

<!-- Logica JS -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/login/inactividad.js"></script>
</head>

<body 	onload = "inactividadJs.inicio()" 
		onkeypress = "inactividadJs.parar('<%=request.getContextPath()%>')" 
		onclick = "inactividadJs.parar('<%=request.getContextPath()%>')" >
        
	<h1 style="color: green">Hello! This is Home Page!</h1>
	<form action="<%=request.getContextPath()%>/logout" method="post">
	    <input type="submit" value="Sign Out"/>
	</form>
	<!-- Modal de inactividad de sesión -->
	<div class="modal fade" id="modalInactividad" data-backdrop="static"  data-keyboard="false" role="dialog">
		<div class="modal-dialog">
	    
			<!-- Modal content-->
			<div class="modal-content">
			    <div class="modal-body">
			    	<p class="text-center"><h1>Tu sesión esta por cerrarse<h1></h1></p>
			    </div>
			    <div class="container">
					<div class="progress" id="myProgress">
				  		<div class="progress-bar progress-bar-striped active" id="myBar" role="progressbar"
				  			aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width:10%">
				    		1 Segundo(s)
				  		</div>
					</div>
				</div>
			    <div class="modal-footer">
			    	<button type="button" id="botonCancelar" class="btn btn-default" data-dismiss="modal">Cancelar</button>
			    </div>
			</div>				      
	    </div>
	</div>
</body>
</html>