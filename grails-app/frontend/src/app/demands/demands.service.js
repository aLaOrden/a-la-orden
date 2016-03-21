(function() {
	'use strict';

	angular
		.module('ingeSoftIi')
		.service('DemandsService', DemandsService);

	/** @ngInject */
	function DemandsService($q) {
		var service = {
			loadDemands: loadDemands
		};
		
		return service;
		
		function loadDemands(){
			var demands = [
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
			return $q.when(demands);
		}
	}
})();
