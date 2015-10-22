<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="myapp">
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular.min.js"></script>
	<script type="text/javascript" src="./controllers/controller.js"></script>
</head>
<body>
	<div class="container" ng-controller="userController">
		<h1>User list app</h1>

		<table class="table">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Lastname</th>
					<th>&nbsp;</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input class="form-control" ng-model="user.id"></td>
					<td><input class="form-control" ng-model="user.name"></td>
					<td><input class="form-control" ng-model="user.lastname"></td>
					<td><button class="btn btn-primary"
							ng-click="addUser()">Guardar</button></td>
				</tr>
				<tr ng-repeat="u in listUsers">
					<th>{{u.id}}</th>
					<th>{{u.name}}</th>
					<th>{{u.lastname}}</th>
					<td><button class="btn btn-danger" ng-click="remove(u.id)">Borrar</button></td>
					<td><button class="btn btn-warning" ng-click="edit(u.id)">Editar</button></td>
				</tr>
			</tbody>
		</table>

	</div>
</body>
</html>