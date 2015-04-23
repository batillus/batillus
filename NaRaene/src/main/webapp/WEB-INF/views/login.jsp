<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../style.css">
    <title>Login page</title>
</head>
<body>
<div align="center"><img src="resources/test.jpg"/></div>
<hr />
<div align="right"><a href="../">Back to home</a></div>
<hr />
<div align="center">
<% String check = (String) request.getAttribute("model"); 

if(check.equals("false")) {%>
    <form method="post" action="login">
        Login:<input type="text" name="userlogin" /><br/>
        <br/>
        Password:<input type="password" name="password" /><br/>
        <br/>
        <input type="submit" value="login" />
        <br/>
       </form>
      <%}%>
       <br/>
      <% if(session.getAttribute("user") != null){
    	  String redirectURL = "userpage";
    	  response.sendRedirect(redirectURL);
      } %>
      
     
</div>
</body>
</html>