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
<form:form id="ingredients_form" method="post" action="/food/form/ingreds_added"   commandName="ings" >
<form:errors path="*" element="div" cssClass="commonerrorblock"/>
Ingredients: <form:textarea path="textIngreds" row="10" col="80"></form:textarea>

<form:errors path="textIngreds" cssClass="error"/>


<input type="submit"  value="Add Ingredients">
</form:form>

</body>
</html>