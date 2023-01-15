<html>
<head>
	<title>Login page</title>
	<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
	<div class="container">
		<h1>Welcome to the Shiny Log!</h1>
	</div>
	<div class="container">
		<h2>Please login to proceed.</h2>
		<font color="red">${errorMessage}</font>
		<form method="post">
			Username: <input type="text" name="username"/></br>
			Password: <input type="password" name="password"/></br>
			<button type="submit" name="login" class="btn btn-info"/>login</button>
		</form>
	</div>
	
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	
</body>
</html>