<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DCOTYPE html>

<html>

	<head>
		<title>List Customers</title>
		<!-- reference to css -->
		<link type="text/css"
			  rel="stylesheet"
			  href="${pageContext.request.contextPath}/resources/css/style.css" />	
	</head>
	<body style="background-color:black;">
	
		<div id = "wrapper">
		
			<div id = "header">
				<h2>CRM - Customer Relationship Manager</h2>
			</div>
			
		</div>
		
		<div id = "container">
			<div id="content">
			
				<!-- add button to add customer -->
				<input type="button" value="Add Customer" 
							onclick="window.location.href='showFormForAdd'; return false; " 
							class="add-button"
				/>
				<!-- add the html table -->
				
				<table>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
					</tr>			
					
					<!-- loop over and print the customers -->
					<c:forEach var="tempCustomer" items="${customers}">
					
						<tr>
							<td> ${tempCustomer.firstName} </td>
							<td> ${tempCustomer.lastName} </td>
							<td> ${tempCustomer.email} </td>
						</tr>
					</c:forEach>
				</table>
				
			</div>
		</div>
	
	</body>
</html>