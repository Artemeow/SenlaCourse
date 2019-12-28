<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pizza party</title>
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}
 
td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}
 
tr:nth-child(even) {
    background-color: #dddddd;
}

</style>
</head>
<body>
<table>
 <tr>
 <th>category</th>
 <th>kind</th>
 <th>user</th>
 <th>quantity</th>
 <th>price</th>
 <th>vendor</th>
 <th>name</th>
 </tr>
 <c:forEach var="product" items="${productList}">
 <tr>
 <td>${product.category.name}</td>
 <td>${product.kind}</td>
 <td>${product.user.name}</td>
 <td>${product.quantity}</td>
 <td>${product.price.price}</td>
 <td>${product.vendor.name}</td>
 <td>${product.name}</td>
 <td></td>
 </tr>
 </c:forEach>
</table>
</body>
</html>