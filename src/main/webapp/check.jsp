<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="user" class="com.example.servletdom.domain.User" scope="session" />

<jsp:setProperty name="user" property="*" /> 

<jsp:useBean id="storage" class="com.example.servletdom.service.UserService" scope="application" />

<% 
if(storage.isUserRegistered(user)) {
	session.setAttribute(user.getName(), "logged");

%>
<p>Zalogowano: ${user.name}! </p>
<%
}
else {
%>
<p> Brak użytkownika w bazie</p>
<%
}
%>
<!-- <p> -->
<!-- <p>Following person has been added to storage: </p> -->
<%-- <p>First name: ${person.firstName} </p> --%>
<%-- <p>Year of birth: <jsp:getProperty name="person" property="yob"></jsp:getProperty></p> --%>
<!-- <p> -->
<!--   <a href="showAllPersons.jsp">Show all persons</a> -->
<!-- </p> -->
</body>
</html>