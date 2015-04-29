<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Home page</title>
</head>
<body>
<h1>Home page</h1>
<p>
Welcome to "Food Making application".<br/>
</p>

<p>${message}</p><br/>

<div>
<a href="${pageContext.request.contextPath}/food/form/ingreds">Add Ingredients</a>
</div>
<div>
<a href="${pageContext.request.contextPath}/food/form/recipes">Add Recipes</a>
</div>
<div>
<a href="${pageContext.request.contextPath}/getrecipe">Get Recipe</a>
</div>

</body>
</html>