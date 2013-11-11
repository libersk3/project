<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:mainLayout title="New Program">
	<form class='well' action='' method='POST'>
		<label for='name'>Program name:</label>
		<input type='text' id='name' name='name' />
		<br>
		<label for='instructor'>Instructor name:</label>
		<input type='text' id='instructor' name='instructor' />
		<br>
		<label for='price'>Price:</label>
		<input type='text' id='price' name='price' />
		<br>
		<input type='submit' value='Create program' />
	</form>
</t:mainLayout>