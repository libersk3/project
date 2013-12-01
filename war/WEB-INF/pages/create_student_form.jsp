<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:mainLayout title="New Student">
	<t:validationErrors errors="${errors}">
		<h2>Errors occurred while attempting to create a new student!</h2>
	</t:validationErrors>

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
		<label for='password'>password: </label>
		<input type='text' id='password' name='password' />
		<br>
		<input type='submit' value='Create Student' />
	</form>
</t:mainLayout>