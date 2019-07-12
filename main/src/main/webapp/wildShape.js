angular.module("wildApp", ["ngRoute"]);
angular.module("wildApp")
	.controller("beastsCtr", function($scope, $http) {
        $scope.sortType = 'name'; // set the default sort type
        $scope.sortReverse = false;  // set the default sort order
        $scope.showExtinct = false;  // set the default sort order
        $scope.showSwarms = false;  // set the default sort order
        $scope.searchBeasts = ''; // set the default search/filter term
        $scope.sortMap = new Map([["name" ,false], ["cr", true], ["size", false], ["hp", true], ["ac", true], ["walkingSpeed", true],
            ["swimmingSpeed", true], ["flyingSpeed", true], ["climbingSpeed", true], ["burrow", true], ["strength", true],
            ["dexterity", true], ["constitution", true], ["intelligence", true], ["wisdom", true], ["charisma", true]]);
        $scope.changeSort = function(sorting) {
            if(sorting == $scope.sortType){
                $scope.sortReverse = !$scope.sortReverse;
                $scope.sortMap.set($scope.sortType, $scope.sortReverse);
            } else{
                $scope.sortType = sorting;
                $scope.sortReverse = $scope.sortMap.get(sorting);
            }
       };
       $scope.showExtinctBeasts = function (entry) {
           return entry.extinct == false || entry.extinct == $scope.showExtinct;
       };
       $scope.showSwarmBeasts = function (entry) {
           return entry.swarm == false || entry.swarm == $scope.showSwarms;
       };
       $scope.changeShowExtinct = function () {
           $scope.showExtinct = !$scope.showExtinct;
       };
       $scope.changeShowSwarms = function () {
           $scope.showSwarms = !$scope.showSwarms;
       };
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