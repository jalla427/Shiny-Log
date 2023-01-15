<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
	<title>Delete hunt</title>
	<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
	<div class="container">
		<h2>About this hunt:</h2>
		<table class="table">
			<caption></caption>
			<thead>
				<tr>
					<th>Pokemon</th>
					<th>Generation</th>
					<th>Hunter</th>
					<th>Encounters</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${hunts}" var="hunt">
					<tr class="danger">
						<td>${hunt.pokename}</td>
						<td>${hunt.gen}</td>
						<td>${hunt.hunter}</td>
						<td>${hunt.encounters}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<div class="container">
		<c:forEach items="${hunts}" var="hunt">
			<p>${hunt.notes}</p>
		</c:forEach>
	</div>
	
	<div class="container">
		<a type="button" class="btn btn-success" href="/records">Back</a>
	</div>
	
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>