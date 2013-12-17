<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:mainLayout title="Enroll Student">
	<h1>Enroll Student in ${program.name}:</h1>
	
	<form class='well' action='' method='POST'>
		<c:if test='${not empty program}'>
			<form action='' method = 'POST'>
			

			
		
			<select name="student">
				<c:forEach items="${StudentsList}" var="student">
					<option value='${student.key.id}'> ${student.fullName}</option>
					
					
					
				</c:forEach>
			</select>
					<c:if test="${not empty program.times}">
					
						<c:forEach items= "${program.times}" var="time">
						
							<h2><input type="checkbox" name="day" value=time.day> 
							${time.day}
							${time._times}<h2>
						</c:forEach>
					</c:if>
				
				
				
				
				<input type='submit' value='Enroll Student'>
			</form>
		</c:if>
</t:mainLayout>
