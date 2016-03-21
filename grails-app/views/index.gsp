<!DOCTYPE html>
<html>
	<head>
		<title>Welcome to Grails</title>
		<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.3.5/angular.min.js"></script>
		<link href='https://fonts.googleapis.com/css?family=Roboto:500,300,700,400' rel='stylesheet' type='text/css'>
		<link href="css/main.css" rel="stylesheet" />
	</head>
	<body ng-app="myApp">
		<div class="header">
			<div class="container">
				<h1>Esta es una prueba</h1>
			</div>
		</div>
		<div class="main" ng-controller="MainController">
			<div class="container">
				<h1>{{ title }}</h1>
				<h2>{{ promo }}</h2>
			</div>
		</div>

		<!-- Modules -->
		<script src="js/app.js"></script>

		<!-- Controllers -->
		<script src="js/controllers/MainController.js"></script>
	</body>
</html>
