<%@ include file="header.jsp" %>  

<form:form name="submitForm" method="POST" modelAttribute="User">
    <div align="center">
    	<div style="color: blue">
    		<h3>This is an example for adding new users</h3> 
    		<h5>(You can add more operations in the same way as the restaurant page.)</h5>  
    	</div>
        <table>
            <tr>
                <td>User Name</td>
                <td><input type="text" name="username" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password" /></td>
            </tr>
            <tr>
                <td>User Group</td>
                <td>
	                <select>
					  <option value="0">Admin</option>
					  <option value="1">Guest</option>
					  <option value="2">Other</option>
					</select>
				</td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Submit" /></td>
            </tr>
        </table>
        <div style="color: red">${error}</div>
    </div>
</form:form>
	
<%@ include file="footer.jsp" %>  