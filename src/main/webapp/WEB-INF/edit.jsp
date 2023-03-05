<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Film</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	
<form:form method="POST" action="updateFilm.do" modelAttribute="film">

<label for="id">ID</label>
<form:input id="id" name="id"
			type="text" path="id"></form:input>

<label for="title">Title</label>
<form:input id="title" name="title"
			type="text" path="title" default="${film.title } placeholder="${film.title }"></form:input>

<label for="release_year">Release Year</label>
<form:input id="release_year" name="release_year"
			type="text" path="release_year"></form:input>

<label for="language_id">Language ID</label>
<form:input id="language_id" name="language_id"
			type="text" path="language_id"></form:input>

<label for="rental_duration">Rental Duration</label>
<form:input id="rental_duration" name="rental_duration"
			type="text" path="rental_duration"></form:input>

<label for="rental_rate">Rental Rate</label>
<form:input id="rental_rate" name="rental_rate"
			type="text" path="rental_rate"></form:input>

<label for="length">Length of Film</label>
<form:input id="length" name="length"
			type="text" path="length"></form:input>

<label for="replacement_cost">Replacement Cost</label>
<form:input id="replacement_cost" name="replacement_cost"
			type="text" path="replacement_cost"></form:input>

<label for="rating">Rating</label>
<form:input id="rating" name="rating"
			type="text" path="rating"></form:input>

<label for="special_features">Special Features</label>
<form:input id="special_features" name="special_features"
			type="text" path="special_features"></form:input>

<label for="description">Description</label>
<form:input id="description" name="description"
			type="text" path="description"></form:input>


</form:form>
	

</body>
</html>