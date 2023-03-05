<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Film Query App</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<div class="container">
		<h1 class="display-4 text-center">Welcome to the Film Query App!</h1>
		<h4 class="text-center">Please choose an option:</h4>
		<div class="row justify-content-center">
			<div class="col-md-6">
				<ul class="list-group">
					<li class="list-group-item"><a href="findFilmByID.html">Find
							a film by ID</a></li>
					<li class="list-group-item"><a href="addAFilm.html">Add a
							film to the database</a></li>
					<li class="list-group-item"><a href="deleteFilm.html">Delete
							a film</a></li>
					<li class="list-group-item"><a href="findFilmByKeyword.html">Search
							films by keyword</a></li>
					<li class="list-group-item">
						<form action="updateFilm.do" method="POST">
							<div class="input-group">
								<input type="text" name="id" class="form-control"
									placeholder="Enter film ID">
								<div class="input-group-append">
									<button class="btn btn-primary" type="submit">Update
										film</button>
								</div>
							</div>
						</form>
					</li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>
