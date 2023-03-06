<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body class="text-center">
	

<body>
	<h1>Update Film</h1>

	<form method="POST" action="filmUpdated.do">

		<input type="hidden" name="id" value="${film.id}" /><br>
		<label for="title">Title:</label><br>
		<input type="text" name="title" value="${film.title}" /><br>
		<label for="description">Description:</label><br>
		<textarea name="description">${film.description}</textarea><br>
		<label for="releaseYear">Release Year:</label><br>
		<input type="text" name="releaseYear" value="${film.releaseYear}" /><br>
		<label for="rentalRate">Rental Rate:</label><br>
		<input type="text" name="rentalRate" value="${film.rentalRate}" /><br>
		<label for="length">Length:</label><br>
		<input type="text" name="length" value="${film.length}" /><br>
		<label for="rating">Rating:</label><br>
		<input type="text" name="rating" value="${film.rating}" /><br>
		<label for="specialFeature">Special Feature:</label><br>
		<input type="text" name="specialFeature" value="${film.specialFeature}" /><br>
		<input type="submit" value="Update Film" />
	</form>
</body>
</html>
	


