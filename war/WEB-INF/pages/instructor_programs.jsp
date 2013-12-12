<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:mainLayout title="Instructor Programs">
		<ul class="accordion">
		<c:forEach items="${programs}" var="program">
			<li>
			<h2>
				<a href="/programs/single?id=${program.key.id}">${program.name}</a>
			</h2>
			<div class ="content">${program.instructor.fullName}
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
			<center><a href="/attendance?id=${program.key.id}" class='button blue'>Take Attendance</a>	
			<a href="/attendance/instructorview?id=${program.key.id}" class='button green'>View Attendance</a></center>
		</c:forEach>
		</ul>
		<br/>
		<br/>
</t:mainLayout>