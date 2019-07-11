angular.module("wildApp", ["ngRoute"]);
angular.module("wildApp")
	.controller("beastsCtr", function($scope, $http) {
        $scope.sortType = 'name'; // set the default sort type
        $scope.sortReverse = false;  // set the default sort order
        $scope.searchBeasts = ''; // set the default search/filter term
		$http({
			method: "GET", url: "getAll.do"
		}).then(function(response) {
			$scope.beasts = response.data;
		});
	});
angular.module("wildApp")
	.config(function($routeProvider, $locationProvider) {
		$locationProvider.hashPrefix("");
		$routeProvider
			.when("/viewBeasts", {
				templateUrl: "beasts.html",
				controller: "beastsCtr"
			})
			.when("/viewDruidRules", {
				templateUrl: "druidRules.html"
			})
			.otherwise({
				template: "<h3 style=\"font-style: oblique\">Welcome!</h3>"
			});
	});