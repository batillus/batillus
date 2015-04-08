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
<% String str = (String) request.getAttribute("model"); 
if(str.equals("fail")/* || str.equals("sasay")*/) {%>
    <form method="post" action="login">
        Login:<input type="text" name="userlogin" /><br/>
        <br/>
        Password:<input type="password" name="password" /><br/>
        <br/>
        <input type="submit" value="login" />
        <br/>
       </form>
      <%}%>
       <h1><%=str %></h1>
      <br/>
      <% String gg = ""; 
      if(session.getAttribute("user") != null){
    	  gg = "welcome " +(String) session.getAttribute("user");
      } 
    	 %>
    	 
    	 <h1><%=gg %></h1>
      
     
</div>
</body>
</html>