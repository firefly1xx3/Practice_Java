<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<title>アカウント新規作成画面</title>
</head>
<body>
	<div class="mx-auto" style="width: 300px;">
		<h1 class="mb-3" style="text-align: center">アカウント新規作成画面</h1>
		<% ArrayList<String> errorMessage = (ArrayList<String>)request.getAttribute("errorMsg"); %>
 		<% if (errorMessage != null) { %> 
			<p class="mb-3" style="text-align: center"> <font color="red"> <%= errorMessage.get(0) %> </font> </p>
 		<% } %> 
		<form action="/new_dev/CreateAccountServlet" method="post">
		  <div class="mb-3">
		    <label for="userName" class="form-label">ユーザー名</label>
		    <input type="text" class="form-control" id="userName" name="user_name">
		  </div>
		  <div class="mb-3">
		    <label for="pass" class="form-label">パスワード</label>
		    <input type="password" class="form-control" id="pass" name="password">
		  </div>
		  <div class="mb-3">
		    <label for="pass" class="form-label">パスワード再入力</label>
		    <input type="password" class="form-control" id="confirmPass" name="confirmation_password">
		  </div>
		  <button type="submit" class="btn btn-primary">新規作成</button>
		</form>
	</div>
</body>
</html>