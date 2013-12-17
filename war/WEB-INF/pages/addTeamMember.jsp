<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:mainLayout title="Add Team Member to ${team.name}">
		<h1>Add member to ${team.name}:</h1>
	
	<form class='well' action='' method='POST'>
			
			<form action='' method = 'POST'>

		<c:forEach items="${students}" var="student">
			<option value='${student.key.id}'> ${student.fullName}</option>
		</c:forEach>
		
		<c:forEach items="${StudentsList}" var="student">
					
					<input type='radio' name='student' value='${student.key.id}'/> ${student.fullName}
					<br/>
				</c:forEach>
					

			
				
				
					<br><input type='submit' value='Add Team Member'>
			</form>
</t:mainLayout>
