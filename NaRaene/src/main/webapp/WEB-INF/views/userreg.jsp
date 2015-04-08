<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" type="text/css" href="../style.css">
<title>Insert title here</title>
</head>
<body>

<% String str = (String) request.getAttribute("model");
if(str.equals("") || str.equals("false")) {%>


<div align="center">
    <form method="post" action="userreg">
        Login:<input type="text" name="login" /><br/>
        <br/>
        Password:<input type="password" name="password" /><br/>
        <br/>
        FirstName:<input type="text" name="firstname" /><br/>
        <br/>
        LastName:<input type="text" name="lastname" /><br/>
        <br/>
        <br/>
        <input type="submit" value="register" />
    </form>
</div>
<%} else { %>

<div align="center">
<h1>registration success</h1>
</div>
<a href = "login">go to login page</a>
<% } %>

</body>
</html>