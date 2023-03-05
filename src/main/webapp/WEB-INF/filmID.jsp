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
			<tr>
				<th>Title</th>
				<td>${film.title}</td>
			</tr>
			<tr>
				<th>Description</th>
				<td>${film.description}</td>
			</tr>
			<tr>
				<th>Release Year</th>
				<td>${film.releaseYear}</td>
			</tr>
			<tr>
				<th>Language ID</th>
				<td>${film.languageId}</td>
			</tr>

			<tr>
				<th>Rating</th>
				<td>${film.rating}</td>
			</tr>
			<tr>
				<th>Rental Rate</th>
				<td>${film.rentalRate}</td>
			</tr>
			<tr>
				<th>Length</th>
				<td>${film.length} minutes</td>
			</tr>
			<tr>
				<th>Special Features</th>
				<td>${film.specialFeature}</td>
			</tr>
			<tr>
				<th>Actors</th>
				<td>
					<ul>
						<c:forEach items="${film.actorList}" var="actor">

							<li>${actor.firstName} ${actor.lastName}</li>

						</c:forEach>
					</ul>
				</td>
			</tr>
			<tr>
				<th>Category</th>
				<td>${film.category}</td>
			</tr>
			<tr>
		</table>
	</c:if>


	<form action="home.do">
		<input type="submit" value="Return Home">
	</form>

</body>
</html>