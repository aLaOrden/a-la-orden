(function() {
	'use strict';

	angular
		.module('ingeSoftIi')
		.controller('MainController', MainController);

	/** @ngInject */
	function MainController($mdSidenav) {
		var vm = this;

		vm.toggleMenu = toggleMenu;

		function toggleMenu() {
			$mdSidenav('left').toggle();
		}
	}
})();
