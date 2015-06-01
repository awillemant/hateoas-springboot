define([ 'modules/hateoasModule',  'resources/Conference'  ], function(hateoasModule) {

	hateoasModule.controller('ConferenceController', function($scope,  $log, Conference, $http) {

		$scope.conferences = [];

		var refreshConferences = function() {
			$log.debug("Rafraichissement de la liste des conferences");
			var futureConferences = Conference.get().$promise;
			futureConferences.then(function(data) {
				$scope.conferences = data._embedded.conferences;
				parseTalks()
				$log.debug($scope.conferences);
			});
		};
		

		refreshConferences();
		
		
		var parseTalks = function(){
			angular.forEach($scope.conferences,function(value,key){
				var futureTalks = $http.get(value._links.talks.href);
				futureTalks.success(function(data){
					if(data._embedded){
						$scope.conferences[key].talks = data._embedded.talks;
					}
				})
			})
		};
		

	});

});