<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">

<head>
<link rel="stylesheet" type="text/css" href="../../css/bootstrap.min.css" />
<title>Offered Recipe</title>
</head>
<body>
<div class="container">

<div style="line-height: 2.5em;">
<a href="${pageContext.request.contextPath}/">Home</a>
</div>

<h1 style="line-height: 2.5em;">Offered Recipe:</h1>


<div>
<h3>${recipe}</h3>
</div>

</div>
</body>
</html>