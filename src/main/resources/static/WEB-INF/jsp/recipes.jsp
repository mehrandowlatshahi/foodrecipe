<!DOCTYPE html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>

<title>Recipes Page</title>
<style>
.error {
 color: red;
 font-weight: bolder;
}
 
.commonerrorblock {
 color: #000;
 background-color: #ffEEEE;
 border: 3px solid #ff0000;
 
}
</style>

</head>
<body>
<div>
<a href="${pageContext.request.contextPath}/">Home</a>
</div>
<form:form id="recipes_form" method="post" action="/food/form/recipes_added"   commandName="recpsCmd" >
<form:errors path="*" element="div" cssClass="commonerrorblock"/>
<div>
Recipes: <form:textarea path="jsonRecipes" row="10" col="80"></form:textarea>
</div>
<form:errors path="jsonRecipes" cssClass="error"/>

<div>
<input type="submit"  value="Add Recipes">
</div>

</form:form>

</body>
</html>