define([ 'angular' ], function(angular) {

	var hateoasModule = angular.module('hateoas', [ 'ngRoute', 'ngResource' ]);

	hateoasModule.value('Constants', {
		urlRoot : 'http://localhost:8080/'

	});



	return hateoasModule;
});