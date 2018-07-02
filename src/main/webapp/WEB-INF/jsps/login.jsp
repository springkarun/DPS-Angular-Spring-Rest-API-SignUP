<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title>Spring Boot Example</title>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<script
			src="http://ajax.googleapis.com/ajax/libs/angularjs/1.6.0/angular.min.js"></script>
	<script src="/js/angular.js"></script>
	<link rel="stylesheet"
		  href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" />
</head>
<body>

<div class="container" ng-app="app">
	<br>
	<h1>DPS School Login Form</h1>

	<div class="row">
		<div ng-controller="loginController" class="col-md-3">
			<form name="customerForm" ng-submit="submitForm()">

				<label>Roll No : </label>
				<input type="text" name="rollNo"	class="form-control" ng-model="rollNo" />

				<br>
				<label>Password :</label>
				<input type="password" name="passwords" class="form-control" ng-model="passwords" />

				<br>
				<button type="submit" class="btn btn-primary">Submit</button>

			</form>
			<p>{{postResultMessage}}</p>

		</div>
	</div>
</div>

</body>
</html>