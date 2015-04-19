<!DOCTYPE html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ingredients Page</title>
</head>
<body>
<form id="ingredients_form"   action="${pageContext.request.contextPath}/form/ingreds_added"  method="post">
Ingredients: 	<form:textarea path="text"  />


<input type="submit"  value="Add Ingredients">
</form>

</body>
</html>