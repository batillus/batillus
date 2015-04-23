<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Map" %>   
<%@ page import="java.util.List" %> 
<%@ page import="NaRaene.NaRaene.domain.Player" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% 
Map<String, Object> modelHashMap = (Map<String, Object>) request.getAttribute("model");
String str = (String) modelHashMap.get("username");
int quantity = (Integer) modelHashMap.get("quantity");
List<Player> list = (List<Player>) modelHashMap.get("playerlist");
%>

welcome <%=str %>
<br/>
you have <%=quantity %> players
<br/>
<% if(quantity > 0) {
for (int i=0;i<list.size();i++){
	String playerName = list.get(i).getPlayerName(); %>
<a href="playerinfo?id=<%=list.get(i).getPlayerId()%>"><%=playerName %></a>
<br/>
	
<%}
	}%>

<br/>
<a href="createplayer">create new player</a>
<br/>




</body>
</html>