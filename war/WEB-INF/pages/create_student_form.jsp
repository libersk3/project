<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:mainLayout title="New Student">
	<c:if test="${not empty errors}">
		<div class="error-message">
			<h2>Errors occurred while attempting to create a new student!</h2>
			<ul>
				<c:forEach var="errorType" items="${errors}">
					<c:forEach var="errorMessage" items="${errorType.value}">
						<li>${errorMessage}</li>
					</c:forEach>
				</c:forEach>
			</ul>
		</div>
	</c:if>

	<form class='well' method='POST'>
		<label for='firstName'>First Name: </label>
		<input type='text' id='firstName' name='firstName' value='${firstName}' />
		<br>
		<label for='lastName'>Last Name: </label>
		<input type='text' id='lastName' name='lastName' value='${lastName}' />
		<br>
		<label for='email'>email: </label>
		<input type='text' id='email' name='email' value='${email}' />
		<br>
		<input type='submit' value='Create Student' />
	</form>
</t:mainLayout>