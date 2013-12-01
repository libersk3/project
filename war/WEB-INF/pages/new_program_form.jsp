<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:mainLayout title="New Program">
	<t:validationErrors errors="${errors}">
		<h2>Errors occurred while attempting to create a new program!</h2>
	</t:validationErrors>

	<form class='well' action='' method='POST'>
		<label for='name'>Program name:</label>
		<input type='text' id='name' name='name' value='${name}' />
		<br>
		<label for='instructor'>Instructor name:</label>
		<input type='text' id='instructor' name='instructor' value='${instructor}' />
		<br>
		<label for='price'>Price:</label>
		<input type='text' id='price' name='price' value='${price}' />
		<br>
		<input type='submit' value='Create program' />
	</form>
</t:mainLayout>
