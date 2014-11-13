<%@page import="java.awt.Stroke"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="storage" class="com.example.servletdom.service.UserService" scope="application" />
<jsp:useBean id="user" class="com.example.servletdom.domain.User" scope="session" />
<jsp:setProperty property="*" name="user" />

<%
Boolean isInDB = storage.add(user);
if (user.getName() != null && user.getPass() != null && isInDB) {
%>
<p>Użytkownik o loginie: ${user.name} został dodany do bazy! </p>
<p>Możesz się teraz zalogować:</p>

<% 
}
else if (user.getName() != null && user.getPass() != null && !isInDB)  {
%>
<p>Użytkownik o podanym loginie już istnieje</p>
<%
}
%>


<form action="check.jsp" method="post">

  Login :<input type="text" name="name" value="${user.name}" /><br />
  Hasło :<input type="password"  name="pass" value="${user.pass}" /><br />
  <input type="submit" value=" OK ">
</form>

<p>Nie masz jeszcze konta?</p>
<p>
  <a href="register.jsp">Załóż nowe</a>
</p>
  
</body>
</html>