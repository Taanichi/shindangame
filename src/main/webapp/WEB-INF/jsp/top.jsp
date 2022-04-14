<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import ="cc.shinbi.shindan.model.Shindan" %>
     <%@ page import ="cc.shinbi.shindan.model.Question" %>
      <%@ page import ="cc.shinbi.shindan.model.Item" %>
      
      <%
        String message = (String)request.getAttribute("message");
      Shindan shindan = (Shindan)request.getAttribute("shindan");
      %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>すみっコぐらし診断</title>
<link rel="stylesheet" type="text/css"
      href="${pageContext.request.contextPath}/css/Style.css">
</head>
<body>
<header>
<h1>すみっコぐらし診断</h1>
</header>
<main>
<div class=sumi>
<p>すみっコぐらし診断へようこそ。すみっこが好きな、ちょっぴりネガティブだけど個性的な“すみっコ”たち。</p>
<p>あなたにそっくりなタイプのすみっコを診断します。</p>
</div>
<%
 if(message != null){
%>
<div id="error"><%= message %></div>
<%
 }
%>
<form method="post" action="${pageContext.request.contextPath}/result">
<h3>あなたのお名前は？</h3>
<input id=baka type="text" name="name">

<%
 for(Question question : shindan.getQuestions()){
	 %>
	 <h3><%= question.getQuestion() %></h3>
	 <div class=box>
	 <%
	 String option = "checked";
	 for(Item item : question.getItems()){
	 %>
	 <div>
	 <input type="radio"
	 name="<%= question.getkey() %>"
	 value="<%= item.getId() %>"
	 <%= option %>
	 >
	 <%= item.getText() %>
	 </div>
	 <%
	 option = " ";
	 }
	 %>
	 
	 </div>
	 
	 <%
 }
	 %>
	 
	 <div id="buttons">
	 <input class=back type="submit" value="診断する">
	 </div>
	 </form>
	 </main>
</body>
</html>