<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="user" class="com.example.servletdom.domain.User" scope="session"/>

<jsp:useBean id="storage" class="com.example.servletdom.service.UserService" scope="application" />

<form action="loggin.jsp" method="post">

  Login :<input type="text" name="name" value="${user.name}" /><br />
  Hasło :<input type="password"  name="pass" value="${user.pass}" /><br />
  <input type="submit" value=" OK ">
</form>

<p>
  <a href="loggin.jsp">Zaloguj</a>
</p>

</body>
</html>				