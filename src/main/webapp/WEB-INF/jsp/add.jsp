<html>
<head>
	<title>Add hunt</title>
	<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>	
	<div class="container">
		<h2>Add a hunt</h2>
		<p>${outcome}</p>
		<form method="post" action="/add">
				<div>Pokemon: <input type="text" name="pokemon"/></div>
				<div>Generation: <input type="number" name="generation"/></div>
				<div>Encounters: <input type="number" name="encounters"/></div>
				<button type="submit" name="addhunt" class="btn btn-success"/>add hunt</button>
		</form>
		<h3>Click <a href="/records">here</a> to return to all hunts</h3>
	</div>
		
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	
</body>
</html>