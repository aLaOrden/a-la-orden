(function() {
  'use strict';

  angular
    .module('ingeSoftIi')
    .run(runBlock);

  /** @ngInject */
  function runBlock($log, $route) {
	$route.reload();
    $log.debug('runBlock end');
  }

})();
