<!DOCTYPE html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../css/bootstrap.min.css" />
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


<div class="container">

<div class="form-group">
<a href="${pageContext.request.contextPath}/">Home</a>
</div>

<div class="form-group">
<form:form role="form" id="ingredients_form" method="post" action="/food/form/ingreds_added"   commandName="ings" >
<form:errors path="*" element="div" cssClass="commonerrorblock"/>
<label for="ingredient">Ingredient</label> 
<form:textarea  path="textIngreds" style="display: block;"></form:textarea>

<form:errors path="textIngreds" cssClass="error"/>

<div class="form-group">
<input class="form-control" type="submit"  value="Add Ingredients">
</div>
</form:form>
</div>
</div>
</body>
</html>