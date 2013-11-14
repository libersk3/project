<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:mainLayout title="New Student">
	<form class='well' method='POST'>
		<label for='firstName'>First Name: </label>
		<input type='text' id='firstName' name='firstName' />
		<br>
		<label for='lastName'>Last Name: </label>
		<input type='text' id='lastName' name='lastName' />
		<br>
		<label for='email'>email: </label>
		<input type='text' id='email' name='email' />
		<br>
		<input type='submit' value='Create Student' />
	</form>
</t:mainLayout>