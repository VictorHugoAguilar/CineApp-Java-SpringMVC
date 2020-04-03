<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<spring:url value="/resources" var="urlPublic" />
<link rel="stylesheet"
	href="${urlPublic}/bootstrap/css/bootstrap.min.css"
	>
<title>Bienvenido a Cine la Esperanza</title>
</head>
<body class="container">
	<%-- 	<h1>Lista de Peliculas</h1>
	<hr />

	<ol>
		<c:forEach items="${ peliculas }" var="pelicula">
			<li>${ pelicula }</li>
		</c:forEach>
	</ol> --%>

	<div class="card mt-4">
		<div class="card-header">
			<h2 class="">Tabla de peliculas</h2>
		</div>
		<div class="card-body">
			<table class="table table-striped table-hover">
				<thead class="thead-dark">
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Título</th>
						<th scope="col">Duración</th>
						<th scope="col">Clasificación</th>
						<th scope="col">Género</th>
						<th scope="col">imagen</th>
						<th scope="col">Fecha Estreno</th>
						<th scope="col">Estatus</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${ peliculas }" var="pelicula">
						<tr>
							<td>${ pelicula.id }</td>
							<td>${ pelicula.titulo }</td>
							<td>${ pelicula.duracion  }min.</td>
							<td>${ pelicula.clasificacion }</td>
							<td>${ pelicula.genero }</td>
							<td><img class="img-fluid" width="80px" height="100px"
								src="${ urlPublic}/images/${ pelicula.imagen }" /></td>
							<td><fmt:formatDate value="${pelicula.fechaEstreno}"
									pattern="dd-MM-yyyy" /></td>
							<td><c:choose>
									<c:when test="${ pelicula.estatus == 'Activa' }">
										<span class="label label-success">Activa</span>
									</c:when>
									<c:otherwise>
										<span class="label label-danger">Inactiva</span>
									</c:otherwise>
								</c:choose></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
	</div>

</body>
</html>