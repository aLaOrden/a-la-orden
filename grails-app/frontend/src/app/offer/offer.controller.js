(function() {
	'use strict';

	angular
		.module('ingeSoftIi')
		.controller('OfferController', OfferController);

	/** @ngInject */
	function OfferController(OfferService) {
		var vm = this;
		
		function loadOffers(){
			OfferService.loadOffers()
				.then(function(offers){
					vm.offers = offers;
				});
		}
		
		loadOffers();
	}
})();
