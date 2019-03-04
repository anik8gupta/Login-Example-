<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	
</head>
<body>

<h2>User Registration!!!!</h2>
<p style="color:green;font-weight:bold;">To add a New User please click</p>
<c:url var="action" value="/user/adduser" ></c:url>
<form:form method="post" action="${action}" commandName="login">
	<table border="1">
	<tr>
		<td>
			UserName
		</td>
		<td>
			<form:input path="userName" />
		</td> 
	</tr>
	<tr>
		<td>
			Password
		</td>
		<td>
			<form:input path="password" />
		</td>
	</tr>
	<tr>
		<td>
			UserType
		</td>
		<td>
			<form:input path="utype" />
		</td>
	</tr>
	<tr>
		<td>
			UserStstus
		</td>
		<td>
			<form:input path="status" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
				<input type="submit"
					value="AddUser" />
		</td>
	</tr>
</table>	
</form:form>
<h1>User Added :${login.userName}</h1>
</body>
</html>
