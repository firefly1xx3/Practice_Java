<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<title>顧客登録画面</title>
</head>
<body>
	<div class="mx-auto" style="width: 300px;">
		<h1 class="mb-3" style="text-align: center">顧客登録</h1>
		<form action="<%= request.getContextPath() %>/CustomerRegisterServlet" method="post">
		  <div class="mb-3">
		    <label for="customerName" class="form-label">お客様名</label>
		    <input type="text" class="form-control" id="customerName" name="name">
		  </div>
		  <div class="mb-3">
		    <label for="customerAddress" class="form-label">住所</label>
		    <input type="text" class="form-control" id="customerAddress" name="address">
		  </div>
		  <div class="mb-3">
		    <label for="customerTel" class="form-label">電話番号</label>
		    <input type="text" class="form-control" id="customerTel" name="tel">
		  </div>
		  <button type="submit" class="btn btn-primary">登録</button>
		</form>
		<div style="text-align:center;">
			<a href="<%=request.getContextPath() %>/CustomerServlet">顧客管理一覧</a>
		</div>
	</div>
</body>
</html>