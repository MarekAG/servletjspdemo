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
			<jsp:useBean id="user" class="com.example.servletdom.domain.User"
				scope="session" />

			<jsp:useBean id="storage"
				class="com.example.servletdom.service.UserService"
				scope="application" />

			<form action="loggin.jsp" method="post">
				<h1>Rejestracja</h1>
				<label class='login'>Login:</label> <input type="text" name="name"
					value="${user.name}" required /><br /> <label class='login'>Hasło:</label>
				<input id="password" name="pass" value="${user.pass}" type="password" pattern="^\S{4,}$"onchange="this.setCustomValidity(this.validity.patternMismatch ? 'Hasło musi mieć conajmniej 4 znaki' : ''); if(this.checkValidity()) form.password_test.pattern = this.value;"
					required><br />  <label class='login'>Powtórz hasło:</label> <input
					id="password_test" name="pass_test" value="${user.pass}" type="password" pattern="^\S{4,}$"
					onchange="this.setCustomValidity(this.validity.patternMismatch ? 'Hasła muszą się zgadzać!' : '');"
					required> <br /> 
					<input type="submit" value=" Zarejestruj ">
			</form>
			
			<br />
			<p>
			<c:if test="${3 eq 3 }">
				<c:out value="Lol" escapeXml="true"></c:out>
		</c:if>
				Masz już konto? <a href="loggin.jsp">Zaloguj się</a>
			</p>
		</div>
	</div>
</body>
</html>
