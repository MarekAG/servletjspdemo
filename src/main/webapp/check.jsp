<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

			<jsp:setProperty name="user" property="*" />

			<jsp:useBean id="storage"
				class="com.example.servletdom.service.UserService"
				scope="application" />

			<c:if test="${storage.isUserRegistered(user)}">
			<% 
			session.setAttribute("logged", user.getName());

			%>

				<script type='text/javascript'>
					setTimeout(function() {
						location.href = 'dom';
					}, 3000);
				</script>
				<p>${user.name} - jesteś teraz zalogowany/a.</p>
				<p>Przekierowywanie...</p>
				<p>
					<a href='dom'>Kliknij tutaj jeśłi przeglądarka nie przekieruje
						cię sama</a>
			</c:if>
			<c:if test="${!storage.isUserRegistered(user)}">

				<script type='text/javascript'>
					setTimeout(function() {
						location.href = 'register.jsp';
					}, 3000);
				</script>
				<p>Brak użytkownika w bazie</p>
			</c:if>
		</div>
	</div>
</body>
</html>