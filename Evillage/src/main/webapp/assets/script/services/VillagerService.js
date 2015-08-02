'use strict';
angular.module('VillagerService', [ 'ngResource' ]).factory('Villager',
		function($resource) {
			return $resource('villager/:identityNumber', {}, {
				get : {
					method : 'GET'
				},
				query : {
					method : 'GET',
					params : {
						identityNumber : 'villagers'
					},
					isArray : true
				},
				post : {
					method : 'POST'
				},
				update : {
					method : 'PUT'
				},
				patch : {
					method : 'PATCH'
				},
				remove : {
					method : 'DELETE'
				}
			})
		});
;