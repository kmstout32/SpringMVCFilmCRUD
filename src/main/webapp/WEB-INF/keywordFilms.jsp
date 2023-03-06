<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find film by keyword</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<c:if test="${not empty film}">
		<h1>Search Results:</h1>
		<table>


			<c:forEach var="film" items="${film}">
				<tr>
					<td>${film.id}</td>
					<td>${film.title}</td>
					<td>${film.description}</td>
					<td>${film.releaseYear}</td>
					<td>${film.language}</td>
					<td>${film.rentalDuration}</td>
					<td>${film.rentalRate}</td>
					<td>${film.length}</td>
					<td>${film.replacementCost}</td>
					<td>${film.rating}</td>
					<td>${film.specialFeature}</td>
					<td>${film.category}</td>
				</tr>
			</c:forEach>

		</table>
		<form action="home.do">
			<input type="submit" value="Return home">
		</form>

	</c:if>

</body>
</html>
