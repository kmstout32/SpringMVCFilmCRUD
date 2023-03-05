<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Film Result</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body class="text-center">
	<form action="updateFilm.do" method="post">
		<input type="hidden" name="id" placeholder=${film.id }value="${film.id }">
		<label>Title</label>
		<input type="text" name="title" value="${film.title }">
		
		<input type="submit" value="update Film">
	</form>

</body>
</html>
