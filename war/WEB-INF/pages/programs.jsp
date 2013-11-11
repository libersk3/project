<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:mainLayout title="Programs">
		<ul>
		<c:forEach items="${programs}" var="program">
			${program.name}
			<br/>
			${program.instructor}
			<br/>
			${program.price}
			<br/>
			<hr/>
		</c:forEach>
		<a href='programs/new'>New Program</a>
</t:mainLayout>