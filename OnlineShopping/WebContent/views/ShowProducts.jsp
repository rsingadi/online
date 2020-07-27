<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
    table, tr,th, td
                    {
                         border: 1px solid black;
                         width : 40%;
                        text-align: center;
                        border-collapse:collapse;
                    }
​    
    </style>   
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<table>
<tr>
<th>ProductNo</th>
<th>ProductName</th>
<th>ProductPrice</th>
<th>Quantity</th>
<th>Discount</th>
 </tr>
<c:forEach var="p" items="${list}">
                        
                        
                            <tr>
                                <td>
                                    <h5><c:out value="${p.getProductNo()}"></c:out></h5>
                                </td>
                                <td>
                                    <h5><c:out value="${p.getProductName()}"></c:out></h5>
                                </td>
                                 <td>
                                    <h5><c:out value="${p.getProductPrice()}"></c:out></h5>
                                </td> 
                                  <td>
                                    <h5><c:out value="${p.getQuantity()}"></c:out></h5>
                                </td> 
                                 <td>
                                    <h5><c:out value="${p.getDiscount()}"></c:out></h5>
                                </td>    
                                  
                            </tr>
                       
                    </c:forEach>       
 </table>
 </center>
</body>
</html>