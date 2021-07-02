<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

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
				<br>
				<!-- Add Search button -->
				<form:form action="searchCustomer" method="GET">
				
					<text style="color:white">Search Customer : </text>
					<input type="text" name="searchName"/>
				
					<input type="submit" value="search" class="add-button"/>
				</form:form>
				
				
				<!-- add the html table -->
				
				<table>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Action</th>
					</tr>			
					
					<!-- loop over and print the customers -->
					<c:forEach var="tempCustomer" items="${customers}">
						
						<!-- construct an update link with customer Id -->
						<c:url var="updateLink" value="/customer/updateDetails" >
							<c:param name="customerId" value="${tempCustomer.id}" />
						</c:url>
						
						<!-- construct an delete link with customer Id -->
						<c:url var="deleteLink" value="/customer/deleteCustomer" >
							<c:param name="customerId" value="${tempCustomer.id}" />
						</c:url>
						
						<tr>
							<td> ${tempCustomer.firstName} </td>
							<td> ${tempCustomer.lastName} </td>
							<td> ${tempCustomer.email} </td>
							<td>
								<a href="${updateLink}">Update</a>
								|
								<a href="${deleteLink}" 
								onClick="if(!(confirm('Are you sure you want to delete this customer'))) return false">
								Delete</a>
							</td>
						</tr>
					</c:forEach>
				</table>
				
			</div>
		</div>
	
	</body>
</html>