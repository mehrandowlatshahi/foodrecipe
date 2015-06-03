<!DOCTYPE html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>

<title>Ingredients Page</title>
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
<a href="${pageContext.request.contextPath}/" style="line-height: 2.5em;">Home</a>
</div>
<form:form id="ingredients_form" method="post" action="/food/form/ingreds_added"   commandName="ings" >
<form:errors path="*" element="div" cssClass="commonerrorblock"/>
Ingredients: <form:textarea path="textIngreds" row="80" col="200"></form:textarea>

<form:errors path="textIngreds" cssClass="error"/>


<input type="submit"  value="Add Ingredients">
</form:form>

</body>
</html>