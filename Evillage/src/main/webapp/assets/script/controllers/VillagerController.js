'use strict';

evillage.controller('VillagerListController', function($scope, Villager) {
	$scope.villagers = Villager.query();
});

evillage.controller('VillagerDetailController', function($scope, Villager) {
	$scope.villager = Villager.get({
		identityNumber : '441421199108144012'
	}, function(villager) {
		console.dir(villager);
	});
});
