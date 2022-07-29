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
	<% int id = (int)request.getSession().getAttribute("userId"); %>
	<!-- The way to get the value which is from session. -->
	<c:set var="userId" value="valueHere" scope="session"  />
	<c:choose>
		<c:when test="${ empty userId }">
			<c:set var="username" value="佐藤愛桜" />
			<c:out value = "${ username }" />
			<c:out value = "${ userId }"/>
			<h1>You Have to log in account!</h1>
			<h3>After 3 seconds, send you to login page.</h3>
			<meta http-equiv="refresh" content="5;URL=/new_dev/LoginServlet">
			<%-- <% response.sendRedirect("LoginServlet"); %> --%>
		</c:when>
		<c:otherwise>
			<h1>My Account Page</h1>
			<p><%= request.getSession().getAttribute("userId") %></p>
<!-- 			<form >
				<input type="button" value="ログアウト">	
			</form> -->
			<input type="button" value="ログアウト" onclick="location.href='/new_dev/SignOutServlet'">
		</c:otherwise>
	</c:choose>
</body>
</html>