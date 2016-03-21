(function() {
	'use strict';

	angular
		.module('ingeSoftIi')
		.controller('DemandsController', DemandsController);

	/** @ngInject */
	function DemandsController(DemandsService) {
		var vm = this;
		
		function loadDemands(){
			DemandsService.loadDemands()
				.then(function(demands){
					vm.demands = demands;
				});
		}
		
		loadDemands();
	}
})();
