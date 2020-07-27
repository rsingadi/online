<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
    table, tr,th,td
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
<th>S.No</th>
<th>Cid</th>
<th>Pid</th>
<th>Grandtotal</th>
<th>Payamount</th>
<th>Pquantity</th>
<th>getTotdiscount</th>
</tr>
	<c:forEach var="p" items="${list}">
		
			<tr>
			</tr>
			<tr>
				<td> 
					<h5>
						<c:out value="${p.getSno() }"></c:out>
					</h5>
					 
				</td>
				
					<td> 
					<h5>
						<c:out value="${p.getId() }"></c:out>
					</h5>
					 
				</td>
				
					<td> 
					<h5>
						<c:out value="${p.getProductNo() }"></c:out>
					</h5>
					 
				</td>
				
					<td> 
					<h5>
						<c:out value="${p.getGrandTotal() }"></c:out>
					</h5>
					 
				</td>
				<td> 
					<h5>
						<c:out value="${p.getPayableAmount() }"></c:out>
					</h5>
					 
				</td>
				<td> 
					<h5>
						<c:out value="${p.getQuantity() }"></c:out>
					</h5>
					 
				</td>
					<td> 
					<h5>
						<c:out value="${p.getTotalDiscount() }"></c:out>
					</h5>
					 
				
			
			</tr>
		
		
		
	</c:forEach>
</table>

</center>
</body>

</html>