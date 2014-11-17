<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<%
			out.println("<div id ='logout'><div id ='loggedUser'>Zalogowany użytkownik: <a href='profile.jsp'>"
					+ session.getAttribute("logged") + "</a></div>");
			out.println("<form action='dom' method='POST'>"
					+ "<input type='hidden' name='logout' value='true'>"
					+ "<input type='submit' value=' Wyloguj' />"
					+ "</form></div>");

				if (session.getAttribute("logged") == null) {
					out.println("<h1>Brak uprawnień</h1>");
					out.println("Musisz się zalogować, aby przejść do tej strony."
							+ "");

					out.println("<script>"
							+ "setTimeout(function(){location.href='loggin.jsp';},3000)"
							+ "</script>");
					return;
				}
				if (request.getParameter("passwd") != null)
					if (!("".equals(request.getParameter("passwd").trim())))
				{
					storage.setPass(session.getAttribute("logged").toString(),
							request.getParameter("passwd"));
			%>
			<script type="text/javascript">
				alert("Hasło zostało zmienione!");
			</script>

			<%
				}
			%>
			<h1>Profil użytkownika</h1>
			<p>Login: ${user.name}</p>



			<form action="profile.jsp" method="post">
				<p>Zmiana hasła:</p>
				<label class='login'>Nowe hasło:</label> <input id="password"
					name="passwd" type="password" pattern="^\S{4,}$"
					onchange="this.setCustomValidity(this.validity.patternMismatch ? 'Hasło musi mieć conajmniej 4 znaki' : ''); if(this.checkValidity()) form.password_test.pattern = this.value;"
					required><br /> <label class='login'>Powtórz
					hasło:</label> <input id="password_test" name="pass_test" type="password"
					pattern="^\S{4,}$"
					onchange="this.setCustomValidity(this.validity.patternMismatch ? 'Hasła muszą się zgadzać!' : '');"
					required> <br /> <input type="submit"
					value=" Zmień hasło ">
			</form>
			<br />
			<div id='backBtn'>
				<form action='dom'>
					<input type='submit' value='Powrót'>
				</form>
			</div>
		</div>
	</div>
</body>
</html>