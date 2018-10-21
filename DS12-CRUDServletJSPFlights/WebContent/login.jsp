<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<style>
	<%@ include file="style.css"%>
</style>
</head>
<body>
	<div class="login-page">
		<div class="form">
			<form action="LoginController" method="post">
				<input type="text" placeholder="username" name="username"/>
				<input type="password" placeholder="password" name="password"/>
				<button>login</button>
			</form>
		</div>
	</div>
</body>
</html>