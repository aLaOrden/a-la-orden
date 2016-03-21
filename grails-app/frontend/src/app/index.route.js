(function() {
  'use strict';

  angular
    .module('ingeSoftIi')
    .config(routeConfig);

  function routeConfig($routeProvider) {
    $routeProvider
		.when('/offer', {
			templateUrl: 'app/offer/offer.html',
			controller: 'OfferController',
			controllerAs: 'vm'
		})
		.when('/demands', {
			templateUrl: 'app/demands/demands.html',
			controller: 'DemandsController',
			controllerAs: 'vm'
		})
		.otherwise({
			redirectTo: '/offer'
		});
  }

})();
