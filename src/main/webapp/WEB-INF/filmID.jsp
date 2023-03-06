<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find film by film id</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

	<c:if test="${not empty film}">
		<table>
			<c:if test="${not empty film.title}">
				<tr>
					<th>Title</th>
					<td>${film.title}</td>

				</tr>
			</c:if>
			<c:if test="${not empty film.description}">
				<tr>
					<th>Description</th>
					<td>${film.description}</td>
				</tr>
			</c:if>
			<c:if test="${not empty film.releaseYear}">
				<tr>
					<th>Release Year</th>
					<td>${film.releaseYear}</td>
				</tr>
			</c:if>
			<c:if test="${not empty film.languageId}">
				<tr>
					<th>Language ID</th>
					<td>${film.languageId}</td>
				</tr>
			</c:if>

			<c:if test="${not empty film.rating}">
				<tr>
					<th>Rating</th>
					<td>${film.rating}</td>
				</tr>
			</c:if>
			<c:if test="${not empty film.rentalRate}">
				<tr>
					<th>Rental Rate</th>
					<td>${film.rentalRate}</td>
				</tr>
			</c:if>
			<c:if test="${not empty film.length}">
				<tr>
					<th>Length</th>
					<td>${film.length}<span>minutes</span>
					</td>
				</tr>
			</c:if>
			<c:if test="${not empty film.specialFeature}">
				<tr>
					<th>Special Features</th>
					<td>${film.specialFeature}</td>
				</tr>
			</c:if>
			<c:if test="${not empty film.actorList}">
				<tr>
					<th>Actors</th>
					<td>
						<ul>
							<c:forEach items="${film.actorList}" var="actor">

								<li>${actor.firstName}${actor.lastName}</li>

							</c:forEach>
						</ul>
					</td>
				</tr>
			</c:if>
			<c:if test="${not empty film.category}">
				<tr>
					<th>Category</th>
					<td>${film.category}</td>
				</tr>
			</c:if>
		</table>
	</c:if>


	<form action="home.do">
		<input type="submit" value="Return Home">
	</form>

	<form action="updateFilmForm.do" method="GET">
		<input type="text" name="id" placeholder="Enter film ID"
			value="${film.id}"> <input type="submit" value="Update">
	</form>

	<form action="deleteFilm.do" method="POST">
		<input value="${film.id}" id="id" name="id" type="text" value>
		<input type="submit" value="Delete film">
	</form>
	<ul>

	</ul>
</body>
</html>

