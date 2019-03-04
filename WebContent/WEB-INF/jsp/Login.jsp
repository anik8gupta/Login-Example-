<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/Test.css">
</head>
<body>
<p style="color:green;font-weight:bold; text-align: center;"> ${msg}</p>
<h1>Please Enter UserId and Password</h1>
<c:url var="action" value="/validuser.html" ></c:url>
<form:form method="post" action="${action}" commandName="login">
<center>
	<table>
	<tr>
		<td>UserName:</td>
		<td><form:input path="userName" /></td>
		<td align="left"><form:errors path="userName" cssClass="error"/></td> 
	</tr>
	<tr>
		<td>Password</td>
		<td><form:password path="password" /></td>
		<td align="left"><form:errors path="password" cssClass="error"/></td> 
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="Login" /></td>
	</tr>
</table>
</center>	
</form:form>
</body>
</html>
