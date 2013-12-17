<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:mainLayout title="Email">

<t:validationErrors errors="${errors}">
		<h2>Errors occurred while attempting send email!</h2>
	</t:validationErrors>

	<form class='well' action='' method='POST'>
	
	<input type='submit' value='email' />
	</form>
</t:mainLayout>