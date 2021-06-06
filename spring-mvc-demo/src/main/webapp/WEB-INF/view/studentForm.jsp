<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

	<head>
		<title>Student Form</title>
	</head>
	
	<body>
		<form:form action="processForm" modelAttribute="student">
		
		First Name : <form:input path="firstName"/>
		<br>
		Last Name : <form:input path="lastName" />
		
		<br>
		<!-- Country : 
			<form:select path="country">
				<form:option value="Brazil" label="Brazil" />
				<form:option value="India" label="India" />
				<form:option value="USA" label="USA" />
				<form:option value="UK" label="UK" />
			</form:select> 
		-->	
		
		Country :
		<form:select path="country">
			<form:options items="${student.countryOptions}" />
		</form:select>
		
		<br>
		
		Your Favorite Programming language : 
		<br>
		
		
		Java<form:radiobutton path="favoriteLang" value="Java" />
		PHP<form:radiobutton path="favoriteLang" value="PHP" />
		Python<form:radiobutton path="favoriteLang" value="Python" />
		C++<form:radiobutton path="favoriteLang" value="C++" />
		
		<br>
		
		Your Operating Systems :
		
		Windows<form:checkbox path="programmingSystems" value="Windows" />
		Linux<form:checkbox path="programmingSystems" value="linux" />
		Mac<form:checkbox path="programmingSystems" value="MacOS" />
		
		<input type = "submit" value = "submit" />
		
		</form:form>
		
		<br>
		
	</body>
</html>