<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="dto.UserInfo" %>
<%@ page import="java.util.*" %>
<% UserInfo user_info = (UserInfo)request.getAttribute("user_info");%>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<title>ユーザー情報更新</title>
</head>
<body>
	<div class="mx-auto" style="width: 500px;">
		<h1 class="mb-3" style="text-align: center">ユーザー情報の更新</h1>
		<h2 class="mb-3" style="text-align: center">変更したいユーザー情報の欄を修正</h2>
		<h2 class="mb-3" style="text-align: center">もしくは追加してください。</h2>
		<form action="<%= request.getContextPath() %>/UpdateAccountInfoServlet" method="post">
		  <div class="mb-3">
		    <label for="customerName" class="form-label">名前</label>
		    <% if (user_info.getName() == null ) { %>
		     	<input type="text" class="form-control" id="userName" name="name">
		    <% } else {%>
		    	<input type="text" class="form-control" id="userName" name="name" value="<%= user_info.getName() %>">
		    <% } %>
		  </div>
		  <div class="mb-3">
		    <label for="customerAddress" class="form-label">生年月日</label>
		    <% if (user_info.getDateOfBirth() == null ) { %>
		     	<input type="text" class="form-control" id="birth" name="dateOfBirth">
		    <% } else {%>
		    	<input type="text" class="form-control" id="birth" name="dateOfBirth" value="<%= user_info.getDateOfBirth() %>">
		    <% } %>
		  </div>
		  <div class="mb-3">
		    <label for="customerAddress" class="form-label">電話番号</label>
		    <% if (user_info.getPhoneNumber() == null ) { %>
		     	<input type="text" class="form-control" id="userPhoneNumber" name="phoneNumber">
		    <% } else {%>
		    	<input type="text" class="form-control" id="userPhoneNumber" name="phoneNumber" value="<%= user_info.getPhoneNumber() %>">
		    <% } %>
		  </div>
		  <div class="mb-3">
		    <label for="customerAddress" class="form-label">eメール</label>
		    <% if (user_info.getEmail() == null ) { %>
		     	<input type="text" class="form-control" id="userEmail" name="email">
		    <% } else {%>
		    	<input type="text" class="form-control" id="userEmail" name="email" value="<%= user_info.getEmail() %>">
		    <% } %>
		  </div>
		  <button type="submit" class="btn btn-primary">登録・修正</button>
		</form>
		<div style="text-align:center;">
			<a href="<%=request.getContextPath() %>/AccountServlet">戻る</a>
		</div>
	</div>
</body>
</html>