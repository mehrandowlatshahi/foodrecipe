<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Edit Shop page</title>
</head>
<body>
<h1>Item Detail page</h1>
<table style="text-align: center;" border="1px" cellpadding="0" cellspacing="0">
<thead>
<tr>
<th width="80px">Style</th><th width="80px">Color</th><th width="200px">description</th><th width="50px">Stock Quantity: </th>
</tr>
</thead>
<tbody>
<tr>
<td>${item.style}</td>
<td>${item.color}</td>
<td>${item.description}</td>
<td>${item.qty}</td>
</tr>
</tbody>
</table>
<a href="${pageContext.request.contextPath}/">Home page</a>
</body>
</html>