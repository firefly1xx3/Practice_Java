<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
	<title>Account page</title>
</head>
<body>
	<div class="mx-auto" style="width: 500px;">
		<div class="mb-3 text-center"> 
			<h1> Profile Page </h1>
		</div>
		<div class="mb-3 text-center">
			<input type="button" value="顧客情報一覧" onclick="location.href='/new_dev/CustomerServlet'">
		</div>
		<div class="mb-3 text-center">
			<input type="button" value="登録情報追加・修正" onclick="location.href='/new_dev/UpdateAccountInfoServlet'">
		</div>
		<div class="mb-3 text-center">
			<input type="button" value="ログアウト" onclick="location.href='/new_dev/SignOutServlet'">
		</div>
	</div>
</body>
</html>