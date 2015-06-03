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

<p>${message}</p>

<div style="line-height: 2.5em;">
<a href="${pageContext.request.contextPath}/food/form/ingreds">Add Ingredients</a>
</div>
<div style="line-height: 2.5em;">
<a href="${pageContext.request.contextPath}/food/form/recipes">Add Recipes</a>
</div>

<div style="line-height: 2.5em;">
<a href="${pageContext.request.contextPath}/getrecipe">Get Recipe</a>
</div>
<c:if test="${ingredslist != null}">
<br style="line-height: 2em;"/>
<input id="show_ingreds" type="checkbox" name="ingreds_chkbox"  onchange="mycheck('show_ingreds','ingreds_table')" />Show Ingredients<br>

<table id = "ingreds_table" style="display: none; text-align: center;" border="1px" cellpadding="0" cellspacing="0"  class="order-table table">
<thead>
<tr>
<th width="150px">Name</th>
<th width="25px">Amount</th>
<th width="25px">Unit</th>
<th width="250px">Use-By</th>
</tr>
</thead>

<tbody>
 <c:forEach items="${ingredslist}" var="ingred">
 <tr>
	<td >${ingred.item}</td>
	<td >${ingred.amount}</td>
	<td >${ingred.unitName}</td>
	<td >${ingred.useBy}</td>	
	</tr> 
 </c:forEach>	


</tbody>

</table>
</c:if>

<c:if test="${recipeslist != null}">

<input id="show_recipes" type="checkbox" name="recipes_chkbox" value="Show Recipes" onchange="mycheck('show_recipes', 'recipes_table')" />Show Recipes<br>

<table id = "recipes_table" style="display:none;  text-align: center;" border="1px" cellpadding="0" cellspacing="0"  class="order-table table">
<thead>
<tr>
<th width="250px">Name</th>
</tr>
</thead>

<tbody>
 <c:forEach items="${recipeslist}" var="recipe">
 <tr>
	<td >${recipe.name}</td>
	</tr> 
 </c:forEach>	


</tbody>

</table>
</c:if>



<script type="text/javascript">


    function mycheck(chkboxid, tblid){

    	
        var a = document.getElementById(chkboxid);        
        var e = document.getElementById(tblid);
        
        e.style.display = (a.checked ? '':'none');
      
     }

</script>
</body>
</html>