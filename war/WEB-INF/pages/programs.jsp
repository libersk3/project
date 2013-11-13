<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:mainLayout title="Programs">
		<ul class="accordion">
		<c:forEach items="${programs}" var="program">	
				
			<li>
			<h2><a href="programs/single?id=${program.key.id}">${program.name}</a></h2>
			<div class ="content">${program.instructor}
			<br/>
			${program.price}
			</div>
			</li>
			<hr/>
		</c:forEach>
		</ul>
		<footer>
		<a href='programs/new' class="button blue">New Program</a>
		</footer>
		<br/>
		<br/>
</t:mainLayout>
