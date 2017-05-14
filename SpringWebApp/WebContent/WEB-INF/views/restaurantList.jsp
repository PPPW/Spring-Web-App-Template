<%@ include file="header.jsp" %> 
 
<center>
	<h2>Welcome ${ userName } ! You are logged in as ${ userGroup }</h2>									       
       <table border="1">	    	
   		<c:if test="${userGroup == 'Admin'}">
			<th><a href="users">Manage users</a></th>			
		</c:if>	    	
    	<th>
    		<a href="logout">Log out</a>
    	</th>
	</table>
	</br>
	<h3><a href="newRestaurant">New Restaurant</a></h3>
	</br>
	
	<table border="1">
		<th>ID</th>
		<th>Name</th>
		<th>Type</th>
		<th>Address</th>
		<th>Action</th>
		<c:forEach var="restaurant" items="${allRestaurants}" varStatus="status">
           <tr>
               <td>${status.index + 1}</td>
               <td>${restaurant.name}</td>
               <td>${restaurant.type}</td>
               <td>${restaurant.address}</td>
               <td>
                   <a href="editRestaurant?id=${restaurant.ID}">Edit</a>
                   &nbsp;&nbsp;&nbsp;&nbsp;
                   <a href="deleteRestaurant?id=${restaurant.ID}">Delete</a>
               </td>                         
           </tr>
           </c:forEach> 
		
		<!-- fake
		<tr>
			<td>1</td>
			<td>KFC</td>
			<td>fast food</td>
			<td>everywhere</td>
			<td>Remove</td>
		</tr>
		-->
       </table>
        
</center>

<%@ include file="footer.jsp" %>  