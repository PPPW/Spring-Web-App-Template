<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Restaurant</title>
</head>
<body>
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
</body>
</html>