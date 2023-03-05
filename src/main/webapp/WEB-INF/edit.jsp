<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Film</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<h2>Enter the following information about the film below</h2>
	<p>${film.id}</p>
	
	<form action="filmId.do" method="POST">

		
		<label for="title">Title:</label> <br><input id="title" name="title"
			type="text" required> <br>  
		<label for="release_year">Release Year:</label> <br>
		<input id="release_year" name="releaseYear" type="number" min="1900"
			max="2023" required> <br> 
			
			<label for="language">Language ID:</label> <br>
			<input id="language" name="languageId" type="number" min="0"
			max="6" required> <br> 
			
		<label for="rental_duration">Rental Duration:</label> <br>
		<input id="rental_duration" name="rentalDuration"
			type="number" min="1" max="45" required> <br>

		<label for="rental_rate">Rental Rate:</label> <br> <input id="rental_rate"
			name="rentalRate" type="number" step="0.01" min="0.01" required> <br> 
			
		<label for="length">Length of film (minutes):</label> <br>
		<input id="length" name="length" type="number" min="5" required> <br> 
			
		<label for="replacement_cost">Replacement Cost:</label> <br>
		<input id="replacement_cost" name="replacementCost" type="number"
			step="0.01" min="0.01" required> <br> 
			
		<label for="rating">Rating:</label><br>
		<input id="rating" name="rating" type="text" required> <br>

		<label for="special_features">Special Features:</label><br> <input
			id="special_features" name="specialFeature" type="text" required><br>
		<label for="description">Description:</label> <br>
		<textarea id="description" name="description" rows="4" cols="50"required></textarea>
		<br>
		 </form>
</body>
</html>