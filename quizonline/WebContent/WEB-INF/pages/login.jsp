<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="images/loginpage.jpg">
<center>
<h1>LOGIN</h1>
<form action="Loginselect" id="carform">
   Email Id:<input type="text" name="email"></br></br>
   Password:<input type="password" name="password"></br></br>
   

<br>
<select name="usertype" form="SELECT">
  <option value="select">select</option>
  <option value="student">student</option>
  <option value="teacher">teacher</option>
  
</select>

<input type="submit">

</form>
</center>
</body>
</html>