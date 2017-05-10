<%@ include file="header.jsp" %> 

<!-- submitted information will be accessed by "loginBean" object -->
<form:form name="submitForm" method="POST" modelAttribute="loginBean">
    <div align="center">
    	<div style="color: blue">${msg}</div>
        <table>
            <tr>
                <td>User Name</td>
                <td><input type="text" name="userName" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password" /></td>
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
