<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Account page</title>
</head>
<body>
<!-- These three steps are necessary for converting integer to String in java -->
	<!-- The way to get the value which is from session. -->
	<% if (request.getSession().getAttribute("userId") == null){ %>
			<h1> userId </h1>
			<h1>ログイン情報がありません。先にログインしてください。</h1>
			<h3>３秒後にログインページに戻ります。</h3>
			<meta http-equiv="refresh" content="3;URL=/new_dev/LoginServlet">
			<%-- <% response.sendRedirect("LoginServlet"); %> --%>
	<%  }
	else { %>
			<h1>マイページ</h1>
			<input type="button" value="顧客情報一覧" onclick="location.href='/new_dev/CustomerServlet'">
			<input type="button" value="ログアウト" onclick="location.href='/new_dev/SignOutServlet'">
	<%} %>
</body>
</html>