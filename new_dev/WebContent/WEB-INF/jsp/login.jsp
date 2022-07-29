<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
	<title>ログイン画面</title>
	<c:if test="${request.getSession().getAttribute('userId') != null }"> 
		<jsp:forward page="account.jsp" />
	</c:if>
</head>
<body>
	<div class="mx-auto" style="width: 300px;">
		<h1 class="mb-3" style="text-align: center">ログイン画面</h1>
		<form action="/new_dev/LoginServlet" method="post">
		  <div class="mb-3">
		    <label for="userName" class="form-label">ユーザー名</label>
		    <input type="text" class="form-control" id="userName" name="user_name">
		  </div>
		  <div class="mb-3">
		    <label for="pass" class="form-label">パスワード</label>
		    <input type="password" class="form-control" id="pass" name="password">
		  </div>
		  <div class="mb-3">
		    <button type="submit" class="btn btn-primary">ログイン</button>
		  </div>
		</form>
		<form action = "/new_dev/CreateAccountServlet" method="get">
		  <div class="mb-3">
		    <input type="submit" value="新規作成">
		  </div>
		</form> 
	</div>
</body>
</html>