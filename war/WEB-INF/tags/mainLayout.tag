<%@tag description="Main page layout" pageEncoding="UTF-8"%>
<%@attribute name="title" required="true"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>${title} - Fantastic Five</title>
	<link rel="stylesheet" type="text/css" href="/assets/stylesheets/default.css"/>
</head>
<body>
	<header class="navbar">
		<div class="brand"><a href="#">Fantastic Five Training Application Prototype</a></div>
		<nav>
			<ul>
				<li><a href="/programs">Programs</a></li>
			</ul>
		</nav>
	</header>
	<article class="main">
		<section>
			<jsp:doBody/>
		</section>
	</article>
</body>
</html>
