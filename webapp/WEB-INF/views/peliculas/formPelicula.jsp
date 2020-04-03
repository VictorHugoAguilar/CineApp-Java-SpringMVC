<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<spring:url value="/resources" var="urlPublic" />
<spring:url value="/peliculas/save" var="urlForm" />
<spring:url value="/" var="urlRoot" />

<title>Creacion de Peliculas</title>

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

		<div class="page-header">
			<h3 class="blog-title">
				<span class="label label-success">Datos de la Pelicula</span>
			</h3>
		</div>

		<!--  Control de errores -->
		<spring:hasBindErrors name="pelicula">
			<div class='alert alert-danger' role='alert'>
				Por favor corrija los siguientes errores:
				<ul>
					<c:forEach var="error" items="${errors.allErrors}">
						<li><spring:message message="${error}" /></li>
					</c:forEach>
				</ul>
			</div>
		</spring:hasBindErrors>

		<form:form modelAttribute="pelicula" action="${urlForm}" method="post"
			enctype="multipart/form-data">

			<div class="row">

				<div class="col-sm-3">
					<div class="form-group">
						<img class="img-rounded"
							src="${urlPublic}/images/${pelicula.imagen}"
							title="${pelicula.imagen}" width="150" height="200" />
					</div>
				</div>
			</div>


			<div class="row">
				<div class="col-sm-3">
					<div class="form-group">
						<label for="titulo">Título</label>
						<form:hidden path="id" />
						<form:hidden path="detalle.id" />
						<form:input path="titulo" type="text" class="form-control"
							name="titulo" id="titulo" required="required" />
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="duracion">Duracion</label>
						<form:input path="duracion" type="text" class="form-control"
							name="duracion" id="duracion" required="required" />
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="clasificacion" class="control-label">Clasificacion</label>
						<form:select path="clasificacion" id="clasificacion"
							name="clasificacion" class="form-control">
							<form:option value="A">Clasificacion A</form:option>
							<form:option value="B">Clasificacion B</form:option>
							<form:option value="C">Clasificacion C</form:option>
						</form:select>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="genero" class="control-label">Genero</label>
						<form:select path="genero" id="genero" name="genero"
							class="form-control" items="${generos}" />

						<%-- Manera antigua estática reemplazado añadiendo la propiedad
							al tag select items={listaGenerada en el controller}
							 	  
							<form:option value="Accion">Accion</form:option>
							<form:option value="Aventura">Aventura</form:option>
							<form:option value="Clasicas">Clasicas</form:option>
							<form:option value="Comedia Romantica">Comedia Romantica</form:option>
							<form:option value="Drama">Drama</form:option>
							<form:option value="Terror">Terror</form:option>
							<form:option value="Infantil">Infantil</form:option>
							<form:option value="Accion y Aventura">Accion y Aventura</form:option>
							<form:option value="Romantica">Romantica</form:option>
						</form:select>
						
						--%>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-sm-3">
					<div class="form-group">
						<label for="estatus" class="control-label">Estatus</label>
						<form:select path="estatus" id="genero" name="estatus"
							class="form-control">
							<form:option value="Activa">Activa</form:option>
							<form:option value="Inactiva">Inactiva</form:option>
						</form:select>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="fechaEstreno">Fecha Estreno</label>
						<form:input path="fechaEstreno" type="text" class="form-control"
							name="fechaEstreno" id="fechaEstreno" required="required" />
					</div>
				</div>

				<div class="col-sm-3">
					<div class="form-group">
						<label for="imagen">Imagen</label>
						<form:hidden path="imagen" />
						<input type="file" id="archivoImagen" name="archivoImagen" />
						<p class="help-block">Imagen de la pelicula</p>
					</div>
				</div>
			</div>


			<div class="page-header">
				<h3 class="blog-title">
					<span class="label label-success">Detalles</span>
				</h3>
			</div>

			<div class="row">
				<div class="col-sm-3">
					<div class="form-group">
						<label for="director">Director</label>
						<form:input path="detalle.director" type="text"
							class="form-control" name="director" id="director"
							required="required" />
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="actores">Actores</label>
						<form:input path="detalle.actores" type="text"
							class="form-control" name="actores" id="actores"
							required="required" />
					</div>
				</div>

				<div class="col-sm-6">
					<div class="form-group">
						<label for="trailer">URL del Trailer (Youtube)</label>
						<form:input path="detalle.trailer" type="text"
							class="form-control" name="trailer" id="trailer"
							placeholder="URL completa del video de YOUTUBE"
							required="required" />
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<label for="sinopsis">Sinopsis</label>
						<form:textarea path="detalle.sinopsis" class="form-control"
							rows="5" name="sinopsis" id="sinopsis"></form:textarea>
					</div>
				</div>
			</div>


			<button type="submit" class="btn btn-danger">Guardar</button>
		</form:form>

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
