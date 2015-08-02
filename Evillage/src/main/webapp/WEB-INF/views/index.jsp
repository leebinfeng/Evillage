<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body data-ng-app="evillage">
	<div data-ng-controller="VillagerListController">
		<table>
			<tr data-ng-repeat="villager in villagers">
				<td>{{villager.identityNumber}}</td>
				<td>{{villager.fullName}}</td>
				<td>{{villager.gender}}</td>
				<td>{{villager.birthday}}</td>
			</tr>
		</table>
	</div>
	<div data-ng-controller="VillagerDetailController">
		<input type="text" data-ng-model="villager.identityNumber">
	</div>
</body>
<script type="text/javascript" src="assets/script/lib/angular.js"></script>
<script type="text/javascript"
	src="assets/script/lib/angular-resource.js"></script>
<script type="text/javascript" src="assets/script/app.js"></script>
<script type="text/javascript"
	src="assets/script/services/VillagerService.js"></script>
<script type="text/javascript"
	src="assets/script/controllers/VillagerController.js"></script>

</html>