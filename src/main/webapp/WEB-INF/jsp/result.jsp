<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="cc.shinbi.shindan.model.Result" %>

<%
String name = (String)request.getAttribute("name");
Result result =(Result)request.getAttribute("result");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>診断結果</title>
<link rel="stylesheet" type="text/css"
      href="${pageContext.request.contextPath}/css/Style.css">
</head>
<body>
<header>
<h1>すみっコぐらし診断　診断結果</h1>
</header>
<div class=box>
<P><%= name %>さんの診断結果は</P>
<p><span id="result"><%= result.getName() %></span>です。</p>
<p><%= result.getDescription() %></p>
</div>
<a class=back href="${pageContext.request.contextPath}/top">戻る</a>
</body>
</html>