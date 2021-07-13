<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
	<head>
		<title>Luv2code Company Page</title>
	</head>
	<body>
		<h2>Luv2code Company Page</h2>
		Welcome to luv2code company Page
		
		<br>
		<form:form action="${pageContext.request.contextPath}/logout" method="POST">
			<input type="submit" value="logout"/>
		</form:form>		
	</body>
</html>