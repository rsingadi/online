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
<th>Cid</th>
<th>Cpassword</th>
<th>Balance</th>
 </tr>
<c:forEach var="p" items="${list}">
                        
                        
                            <tr>
                                <td>
                                    <h5><c:out value="${p.getId()}"></c:out></h5>
                                </td>
                                <td>
                                    <h5><c:out value="${p.getPassword()}"></c:out></h5>
                                </td>
                                 <td>
                                    <h5><c:out value="${p.getBalance()}"></c:out></h5>
                                </td> 
                                    
                                  
                            </tr>
                       
                    </c:forEach>       
 </table>
 </center>
</body>
</html>