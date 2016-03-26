(function() {
  'use strict';

  angular
    .module('ingeSoftIi')
    .config(routeConfig);

  function routeConfig($routeProvider) {
    $routeProvider
		.when('/login', {
			templateUrl: 'app/login/login.html',
			controller: 'LoginController',
			controllerAs: 'vm'
		})

		.otherwise({
			redirectTo: '/login'
		});
  }

})();
