(function() {
  'use strict';

  angular
    .module('ingeSoftIi')
    .config(config);

  /** @ngInject */
  function config($logProvider, toastrConfig, $mdThemingProvider, $mdIconProvider) {
    // Enable log
    $logProvider.debugEnabled(true);

    // Set options third-party lib
    toastrConfig.allowHtml = true;
    toastrConfig.timeOut = 3000;
    toastrConfig.positionClass = 'toast-top-right';
    toastrConfig.preventDuplicates = true;
    toastrConfig.progressBar = true;
	
	$mdIconProvider
		.defaultIconSet("assets/svg/avatars.svg", 128)
		.icon("menu", "assets/svg/menu.svg", 24)
		.icon("share", "assets/svg/share.svg", 24)
		.icon("notifications", "assets/svg/notifications.svg", 24)
		.icon("email", "assets/svg/email.svg", 24)
		.icon("add", "assets/svg/add.svg", 24)
		.icon("arrow_forward", "assets/svg/arrow_forward.svg", 24)
		.icon("google_plus", "assets/svg/google_plus.svg", 512)
		.icon("hangouts", "assets/svg/hangouts.svg", 512)
		.icon("twitter", "assets/svg/twitter.svg", 512)
		.icon("phone", "assets/svg/phone.svg", 512);

	$mdThemingProvider.theme('default')
		.primaryPalette('teal')
		.accentPalette('deep-orange');
  }

})();
