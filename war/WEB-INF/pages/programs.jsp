<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:mainLayout title="Programs">
		<c:forEach items="${programs}" var="program">
			<a href="programs/single?id=${program.key.id}">${program.name}</a>
			<br/>
			${program.instructor}
			<br/>
			${program.price}
			<br/>
			<hr/>
		</c:forEach>
		<a href='programs/new'>New Program</a>
		<br/>
		<br/>
		<a href='/homepage'>Home</a>
		<a href='/login'>Log Out</a>
</t:mainLayout>
