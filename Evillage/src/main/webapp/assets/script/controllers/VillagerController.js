'use strict';

evillage.controller('VillagerListController', function($scope, Villager) {
	$scope.villagers = Villager.query();
	console.log($scope.villagers);
//	$scope.$watch('villagers', function() {
//
//		console.log($scope.villagers);
//	});
});

evillage.controller('VillagerDetailController', function($scope, Villager) {
	$scope.villager = Villager.get({
		identityNumber : '441421199108144012'
	});
	console.log($scope.villager);
});
