<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Web App Template</title>
</head>
<body>
	<center>
		<h2>${msg}</h2>									       
        <table border="1">	    	
    		<c:if test="${userGroup == 'Admin'}">
				<th><a href="users">Manage users</a></th>			
			</c:if>	    	
	    	<th>
	    		<a href="logout">Log out</a>
	    	</th>
		</table>
		</br>
		<h3><a href="restaurantList">View Restaurants</a></h3>
		</br>				
         
	</center>
</body>
</html>