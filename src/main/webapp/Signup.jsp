<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="SignupServlet" method="post">
	FirstName: <input type="text" name="firstName"/><Br><br>
	Email:<input type="text" name="email"/><Br><br>
	Password:<input type="text" name="password"/><Br><br>
	Gender:  Male<input type="radio" value="male" name="gender"/>
			Female<input type="radio" value="female" name="gender"/>
			<br><br>
	<input type="submit" value="Signup"/>

</form>
</body>
</html>