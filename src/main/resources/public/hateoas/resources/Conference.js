define([ 'modules/hateoasModule' ], function(hateoasModule) {
	hateoasModule.factory('Conference', function($resource, Constants) {
		return $resource(Constants.urlRoot+'conferences/:id', {
			id : '@id'
		});
	});
});