<%@ include file="header.jsp" %>  

<div align="center">
    <h1>New/Edit Restaurant</h1>
    <form:form action="editRestaurant" method="post" modelAttribute="restaurant">
    <table>
        <form:hidden path="id"/>
        <tr>
            <td>Name:</td>
            <td><form:input path="name" /></td>
        </tr>
        <tr>
            <td>Type:</td>
            <td><form:input path="type" /></td>
        </tr>
        <tr>
            <td>Address:</td>
            <td><form:input path="address" /></td>
        </tr>            
        <tr>
            <td colspan="2" align="center">
            	<input type="submit" value="Submit">
            </td>
        </tr>
    </table>
    </form:form>
</div>
    
<%@ include file="footer.jsp" %>  