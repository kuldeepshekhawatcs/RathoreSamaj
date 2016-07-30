myController.controller('loginCtrl',['$scope','$location','loginFactory','$rootScope',function($scope,$location,loginFactory,$rootScope){
	$scope.input = new 	loginFactory();
	$scope.save = function(){
		$scope.input.$save({username: $scope.username, password : $scope.password},function(){
			$location.path("/dashboard");
			$rootScope.showLogin = false;
		});
	};
			
			
}]);
