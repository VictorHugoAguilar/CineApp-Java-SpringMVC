<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<spring:url value="/resources" var="urlPublic" />
<spring:url value="/banners/save" var="urlForm" />
<spring:url value="/" var="urlRoot" />

<title>Creacion de Banners</title>

<link href="${urlPublic}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
<link href="${urlPublic}/css/styleNavBar.css" rel="stylesheet">
<link href="${urlPublic}/css/styleFooter.css" rel="stylesheet">

</head>

<body>
	<!-- Fixed navbar -->
	<jsp:include page="../includes/menu.jsp"></jsp:include>

	<div class="container theme-showcase" role="main">

		<h3 class="blog-title">
			<span class="label label-success">Datos de la imagen</span>
		</h3>

		<form action="${urlForm}" method="post" enctype="multipart/form-data">
			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<label for="titulo">Titulo</label> <input type="text"
							class="form-control" name="titulo" id="titulo"
							required="required" />
					</div>
				</div>


				<div class="col-sm-3">
					<div class="form-group">
						<label for="imagen">Imagen</label> <input type="file"
							id="archivoImagen" name="archivoImagen" required="required" />
						<p class="help-block">Tamaño recomendado: 1140 x 250</p>
					</div>
				</div>

				<div class="col-sm-3">
					<div class="form-group">
						<label for="estatus">Estatus</label> <select id="estatus"
							name="estatus" class="form-control">
							<option value="Activo">Activo</option>
							<option value="Inactivo">Inactivo</option>
						</select>
					</div>
				</div>
			</div>

			<button type="submit" class="btn btn-danger">Guardar</button>
		</form>

		<br />

	</div>
	<!-- /container -->

	<!-- FOOTER -->
	<jsp:include page="../includes/footer.jsp"></jsp:include>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script type="text/javascript"
		src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="${urlPublic}/tinymce/tinymce.min.js"></script>
	<script type="text/javascript"
		src="${urlPublic}/bootstrap/jquery-ui/external/jquery/jquery.js"></script>
	<script type="text/javascript"
		src="${urlPublic}/bootstrap/jquery-ui/jquery-ui.js"></script>
	<script>
		$.datepicker.regional['es'] = {
			closeText : 'Cerrar',
			currentText : 'Hoy',
			monthNames : [ 'Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo',
					'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre',
					'Noviembre', 'Diciembre' ],
			monthNamesShort : [ 'Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun',
					'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic' ],
			dayNames : [ 'Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves',
					'Viernes', 'Sábado' ],
			dayNamesShort : [ 'Dom', 'Lun', 'Mar', 'Mié', 'Juv', 'Vie', 'Sáb' ],
			dayNamesMin : [ 'Do', 'Lu', 'Ma', 'Mi', 'Ju', 'Vi', 'Sá' ],
			weekHeader : 'Sm',
			dateFormat : 'dd-mm-yy',
			firstDay : 1,
			isRTL : false,
			showMonthAfterYear : false,
			yearSuffix : ''
		};
		$.datepicker.setDefaults($.datepicker.regional['es']);
		$(function() {
			$("#fechaEstreno").datepicker({
				dateFormat : 'dd-mm-yy'
			});
		});
	</script>
</body>
</html>
