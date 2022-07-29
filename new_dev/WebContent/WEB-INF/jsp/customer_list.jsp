<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.Customer" %>
<%@ page import="java.util.*" %>
<% List<Customer> customer_data = (List<Customer>)request.getAttribute("customer");%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顧客一覧</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
</head>
<body>
	<div class="mx-auto text-center" style="width: 70%;">
	<h2 class="text-center mb-3">顧客管理一覧</h2>
	<table class="table table-striped">
		<thead>
			 <tr>
			 	<th scope="col">ID</th>
			 	<th scope="col">お客様名</th>
			 	<th scope="col">住所</th>
			 	<th scope="col">電話番号</th>
			 	<th scope="col"></th>
			 </tr>
		</thead>
		<tbody>
			 <% for(Customer cus : customer_data){ %>
			 <tr>
			 	<td><%= cus.getId() %></td>
			 	<td><%= cus.getName() %></td>
			 	<td><%= cus.getAddress() %></td>
			 	<td><%= cus.getPhoneNumber() %></td>
			 </tr>
			 <% } %>
		</tbody>
	</table>
	<a href="<%= request.getContextPath() %>/CustomerRegisterServlet">顧客登録</a>
</div>
</body>
</html>