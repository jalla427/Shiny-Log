<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
	<title>Records page</title>
	<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
	<div class="container">
		<h2>Welcome ${loginName}</h2>
	</div>
	
	<div class="container">
		<form method="post" action="/records">
				<div>Pokemon: <input type="text" name="pokemon"/></div>
				<div>Generation: <input type="number" name="generation"/></div>
				<div>Hunter: <input type="text" name="hunter"/></div>
				<button type="submit" name="search" class="btn btn-info"/>search</button>
		</form>
		<h3>Add a hunt <a href="/add">here</a></h3>
	</div>
	
	<div class="container">
	<table class="table">
		<caption></caption>
		<thead>
			<tr>
				<th>Pokemon</th>
				<th>Generation</th>
				<th>Hunter</th>
				<th>Encounters</th>
				<th>Delete</th>
				<th>Summary</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${hunts}" var="hunt">
				<tr class="success">
					<td>${hunt.pokename}</td>
					<td>${hunt.gen}</td>
					<td>${hunt.hunter}</td>
					<td>${hunt.encounters}</td>
					<td>
						<c:set var="name" value="${loginName}"/>
						<c:set var="hunter" value="${hunt.hunter}"/>
						<c:if test="${name.equalsIgnoreCase(hunter)}">
							<a type="button" class="btn btn-danger" href="/delete?hid=${hunt.hid}">Delete</a>
						</c:if>
					</td>
					<td><a type="button" class="btn btn-info" href="/about?hid=${hunt.hid}">About</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
		
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	
</body>
</html>