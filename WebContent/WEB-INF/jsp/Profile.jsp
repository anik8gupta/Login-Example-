<%@page import="com.saurabh.form.Login"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="index.jsp"/>
<%
	Login l=(Login)session.getAttribute("login");
	if(l!=null)
	{
%>
<h1>Name:<%=l.getUserName() %></h1>
<h1>Password:<%=l.getPassword()%></h1>

<%}
	else
	{
		out.println("<h2>Please Login First</h2>");
	}
%>
</body>
</html>