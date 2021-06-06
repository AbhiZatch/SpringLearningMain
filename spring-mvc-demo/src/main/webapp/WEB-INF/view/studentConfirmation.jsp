<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

	<head>
		<title>Student Confirmation</title>
	</head>
	<body>
		Student is Confirmed : ${student.firstName} ${student.lastName} 
		<br>
		From : ${student.country} 
		<br>
		Favorite Language : ${student.favoriteLang}
		<br>
		Operating Systems : 
		<ul>
			<c:forEach var="temp" items="${student.programmingSystems}">
			<li> ${temp} </li>
			</c:forEach>
		</ul>
		
	</body>
</html>