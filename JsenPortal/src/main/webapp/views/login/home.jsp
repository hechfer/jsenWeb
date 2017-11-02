<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<!-- JQUERY -->
<script src="https://code.jquery.com/jquery-1.11.3.min.js"
	integrity="sha256-7LkWEzqTdpEfELxcZZlS6wAx5Ff13zZ83lYO2/ujj7g="
	crossorigin="anonymous"></script>

<!-- BOOTSTRAP -->
<script type="text/javascript"
	src="<%=request.getContextPath()%>/static/tether/js/tether.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/static/bootstrap/js/bootstrap.min.js"></script>

<!-- ESTILOS BOOTSTRAP Y PROPIOS DE LA P�GINA -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/bootstrap/css/bootstrap.min.css">
<link href="<%=request.getContextPath()%>/static/css/home.css"
	type="text/css" rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/static/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- Logica JS -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/login/inactividad.js"></script>
</head>

<body onload="inactividadJs.inicio()"
	onkeypress="inactividadJs.parar('<%=request.getContextPath()%>')"
	onclick="inactividadJs.parar('<%=request.getContextPath()%>')">
	<form action="<%=request.getContextPath()%>/logout" method="post">
		<!-- Inicia página -->
		<nav class="navbar navbar-toggleable-md navbar-inverse bg-inverse bg-faded"
			id="mainNav"> <a class="navbar-brand" href="#">Bienvenido a Jsen</a>
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
	
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
					<li class="nav-item" data-toggle="tooltip" data-placement="right"
						title="Perfil">
						<a class="nav-link" href="home.jsp">
							<i class="fa fa-fw fa-user-o"></i> <span class="nav-link-text">Perfil</span>
						</a>
					</li>
					<li class="nav-item" data-toggle="tooltip" data-placement="right" title="Seguridad">
						<a class="nav-link nav-link-collapse collapsed" data-toggle="collapse"
							href="#collapseComponents" data-parent="#exampleAccordion"> 
							<i class="fa fa-fw fa-unlock"></i> 
							<span class="nav-link-text">Seguridad</span>
						</a>
						<ul class="sidenav-second-level collapse" id="collapseComponents">
							<li><a class="nav-link-text" href="#">Ejemplo 1</a></li>
							<li><a class="nav-link-text" href="#">Ejemplo 2</a></li>
						</ul>
					</li>
					<li class="nav-item" data-toggle="tooltip" data-placement="right"
						title="Localizacion">
						<a class="nav-link nav-link-collapse collapsed" data-toggle="collapse"
						href="#collapseLocalizacion" data-parent="#exampleAccordion">
							<i class="fa fa-fw fa-location-arrow"></i>
							<span class="nav-link-text">Localización</span>
						</a>
						<ul class="sidenav-second-level collapse" id="collapseLocalizacion">
							<li><a class="nav-link-text" href="#">Historial de Localizaciones</a></li>
							<li><a class="nav-link-text" href="#">Localizar Móvil</a></li>
						</ul>
					</li>
				</ul>
			</div>
			
			<form class="form-inline my-2 my-lg-0">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">
					<span class="fa fa-fw fa-power-off"></span> Salir de Jsen
				</button>
			</form>
		</nav>
		
		<div class="content-wrapper">
	      	 <div class="container-fluid">
			    <ol class="breadcrumb">
			    	<li class="breadcrumb-item">
			        	<a href="#">Navegación</a>
			        </li>
			        <li class="breadcrumb-item active">Mapa</li>
			    </ol>
			 	<div class="row">
			    	<div id="map" class="col-lg-8"></div>
			       	<div class="col-lg-3">
			         	<div class="card mb-3">
			            	<div class="card-header">
			              		<i class="fa fa-pie-chart"></i>Detalles
			              	</div>
			            	<div class="card-body">
			              		<canvas id="detalles" width="100%" height="170"></canvas>
			            	</div>
			          		<div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
			          	</div>
			           	<div class="card mb-3">
			            	<div class="card-header">
			              		<i class="fa fa-pie-chart"></i>Funciones
			              	</div>
			            	<div class="card-body">
			              		<canvas id="detalles" width="100%" height="170"></canvas>
			            	</div>
			            	<div class="card-footer small text-muted">Updated yesterday at 11:58 PM</div>
			          	</div>
			        </div>
	      		</div>
      	 	</div>
      	 </div>
	</form>


	<!-- Modal de inactividad de sesi�n -->
	<div class="modal fade" id="modalInactividad" data-backdrop="static" data-keyboard="false" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-body">
					<p class="text-center">
					<h1>Tu sesi&oacute; qn esta por cerrarse</h1>
					</p>
				</div>
				<div class="container">
					<div class="progress" id="myProgress">
						<div class="progress-bar progress-bar-striped active" id="myBar"
							role="progressbar" aria-valuenow="40" aria-valuemin="0"
							aria-valuemax="100" style="width: 10%">1 Segundo(s)</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" id="botonCancelar" class="btn btn-default"
						data-dismiss="modal">Cancelar</button>
				</div>
			</div>
		</div>
	</div>
	
	<footer class="sticky-footer">
		<div class="container">
			<div class="text-center">
				<small>Copyright © Jsen 2017</small>
			</div>
		</div>
	</footer>
</body>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/util/iniciarMapa.js"></script>
<script async defer src="https://maps.googleapis.com/maps/api/js?key=KEY=initMap"></script>
</html>
