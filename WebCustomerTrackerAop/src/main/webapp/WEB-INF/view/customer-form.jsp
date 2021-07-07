<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DCOTYPE html>

<html>

	<head>
		<title>Add Customers</title>
		<!-- reference to css -->
		<link type="text/css"
			  rel="stylesheet"
			  href="${pageContext.request.contextPath}/resources/css/style.css" />	
	</head>
	<body style="background-color:black;">
	
		<div id="header">
			<h2>CRM - Customer relationShip Manager</h2>
		</div>
	
		<form:form action="saveCustomer" modelAttribute="customer" method="POST">
			
			<!-- need to associate this data with customer id -->
			<form:hidden path="id"/>
			
			<table>
				<tbody>
					<tr>
						<td><label>First Name</label></td>
						<td><form:input path="firstName"/></td>
					</tr>
					<tr>
						<td><label>Last Name</label></td>
						<td><form:input path="lastName"/></td>
					</tr>
					<tr>
						<td><label>Email</label></td>
						<td><form:input path="email"/></td>
					</tr>
					<tr>
						
						<td><input type="submit" value="Save" /></td>
					</tr>
					
				</tbody>
			</table>
			
		</form:form>
		
		<div style="clear; both; ">
			<p>
				<a href="${pageContext.request.contextPath}/customer/list">Back To List</a>
			</p>
		</div>
	
	</body>
</html>