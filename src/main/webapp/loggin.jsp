<%@page import="java.awt.Stroke"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel='stylesheet' type='text/css' href='style.css'>
<title>Dom</title>
</head>
<body>
	<div id='site'>
		<div id='content'>
			<jsp:useBean id="storage"
				class="com.example.servletdom.service.UserService"
				scope="application" />
			<jsp:useBean id="user" class="com.example.servletdom.domain.User"
				scope="session" />
			<jsp:setProperty property="*" name="user" />
			<h1>Logowanie</h1>			
			<%
				Boolean isInDB = storage.add(user);
				if (user.getName() != null && user.getPass() != null && isInDB) {
			%>
			<p>Użytkownik o loginie: ${user.name} został dodany do bazy!</p>
			<p>Możesz się teraz zalogować:</p>


			<%
				} else if (!isInDB && request.getParameter("name") != null) {
			%>
			

			<p>Użytkownik o podanym loginie już istnieje</p>

			<%
				}
			%>


			<form action="check.jsp" method="post">
				<p>Ta strona wymaga uwierzytelnienia. Zaloguj się, aby
					kontynuować:</p>
				<label class='login'>Login:</label> <input type="text" name="name"
					value="${user.name}" required /><br /> <label class='login'>Hasło:</label>
				<input type="password" name="pass" required /><br />
				<input type="submit" value=" Zaloguj ">
			</form>
			<br />
			<p>
				Nie masz jeszcze konta? <a href="register.jsp">Załóż nowe</a>
			</p>
		</div>
	</div>
</body>
</html>