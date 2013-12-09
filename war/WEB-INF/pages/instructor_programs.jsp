<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:mainLayout title="Instructor Programs">
		<ul class="accordion">
		<c:forEach items="${programs}" var="program">
			<li>
			<h2><a href="/programs/single?id=${program.key.id}">${program.name}</a></h2>
			<a href="/attendance?id=${program.key.id}">Take Attendance</a>
			<a href="/attendance/instructorview?id=${program.key.id}">View Attendance</a>
			<div class ="content">${program.instructor}
			<br/>
			${program.price}
			<c:if test="${not empty program.times}">
				<c:forEach items= "${program.times}" var="time">
					<br/>
					${time.day}
					${time._times}
					<hr/>
				</c:forEach>
			</c:if>
		</c:forEach>
		</ul>
		<br/>
		<br/>
</t:mainLayout>