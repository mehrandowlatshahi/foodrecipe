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
<i>${message}</i><br/>

<a href="${pageContext.request.contextPath}/food/form/ingreds">Add Ingredients</a>

<a href="${pageContext.request.contextPath}/food/form/recipes">Add Recipes</a>



</body>
</html>