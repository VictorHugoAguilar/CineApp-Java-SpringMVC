<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<spring:url value="/horarios/save" var="urlForm" />
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
			<span class="label label-success">Datos del Horario</span>
		</h3>
		
		<c:if test="${ mensaje != null }">
			<div class="alert alert-success" role="alert">${ mensaje }</div>
		</c:if>

		<spring:hasBindErrors name="horario">
			<div class='alert alert-danger' role='alert'>
				Por favor corrija los siguientes errores:
				<ul>
					<c:forEach var="error" items="${errors.allErrors}">
						<li><spring:message message="${error}" /></li>
					</c:forEach>
				</ul>
			</div>
		</spring:hasBindErrors>

		<form:form action="${urlForm}" method="POST" modelAttribute="horario">
			<div class="row">
				<div class="col-sm-3">
					<div class="form-group">
						<label for="idPelicula" class="control-label">Pelicula</label>
						<form:select id="idPelicula" path="pelicula.id"
							items="${peliculas}" itemValue="id" itemLabel="titulo"
							class="form-control" />
						<%-- 
								<option value="1">Titulo Pelicula 1</option>
								<option value="2">Titulo Pelicula 2</option>
								<option value="3">Titulo Pelicula 3</option>                
							</select> --%>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-3">
					<div class="form-group">
						<label for="fecha">Fecha</label>
						<form:input type="text" class="form-control" path="fecha"
							id="fecha" required="required" />
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="hora">Hora</label>
						<form:input type="text" class="form-control" path="hora" id="hora"
							placeholder="Formato: HH:mm Ejemplo 21:30" required="required" />
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label for="sala" class="control-label">Sala</label>
						<form:select id="sala" path="sala" items="${salas}"
							class="form-control" />

						<%-- <option value="Premium">Sala Premium</option>
								<option value="Sala 1">Sala 1</option>
								<option value="Sala 2">Sala 2</option>
								<option value="Sala 3">Sala 3</option>                
							</select> --%>
					</div>
				</div>

				<div class="col-sm-3">
					<div class="form-group">
						<label for="precio">Precio</label>
						<form:input type="text" class="form-control" path="precio"
							id="precio" required="required" />
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
