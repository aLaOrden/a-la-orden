(function() {
	'use strict';

	angular
		.module('ingeSoftIi')
		.service('OfferService', OfferService);

	/** @ngInject */
	function OfferService($q) {
		var service = {
			loadOffers: loadOffers
		};
		
		return service;
		
		function loadOffers(){
			var offers = [
				{
					title: "Curso de organo",
					description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla quam velit, vulputate eu pharetra nec, mattis ac neque. Duis vulputate commodo lectus, ac blandit elit tincidunt id.",
					score: 3,
					price: "$ 99.999",
					image_url: "assets/images/angular-material.png"
				},
				{
					title: "Curso de organo",
					description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla quam velit, vulputate eu pharetra nec, mattis ac neque. Duis vulputate commodo lectus, ac blandit elit tincidunt id.",
					score: 3,
					price: "$ 99.999",
					image_url: "assets/images/angular-material.png"
				},
				{
					title: "Curso de organo",
					description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla quam velit, vulputate eu pharetra nec, mattis ac neque. Duis vulputate commodo lectus, ac blandit elit tincidunt id.",
					score: 3,
					price: "$ 99.999",
					image_url: "assets/images/angular-material.png"
				},
				{
					title: "Curso de organo",
					description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla quam velit, vulputate eu pharetra nec, mattis ac neque. Duis vulputate commodo lectus, ac blandit elit tincidunt id.",
					score: 3,
					price: "$ 99.999",
					image_url: "assets/images/angular-material.png"
				},
				{
					title: "Curso de organo",
					description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla quam velit, vulputate eu pharetra nec, mattis ac neque. Duis vulputate commodo lectus, ac blandit elit tincidunt id.",
					score: 3,
					price: "$ 99.999",
					image_url: "assets/images/angular-material.png"
				}
			];
			return $q.when(offers);
		}
	}
})();
