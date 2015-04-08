<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div align="center">
    <form method="post" action="createplayer">
        Characters name:<input type="text" name="name" /><br/>
        <br/>
        character type:<input type="text" name="type" /><br/>
        <br/>
        <br/>
        <input type="submit" value="register" />
    </form>
</div>

	<%
		String str = (String) request.getAttribute("model");  //esli novij igrok zaregalsa to redirekt
		if (str.equals("true")) {
			String redirectURL = "userpage";
			response.sendRedirect(redirectURL);
		}
	%>
</body>
</html>