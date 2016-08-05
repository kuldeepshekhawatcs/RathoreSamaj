myController.controller('loginCtrl',['$scope','$location','loginFactory','$rootScope',function($scope,$location,loginFactory,$rootScope){
	$scope.input = new 	loginFactory();
	$scope.save = function(){
		if($scope.loginForm.$valid){
			$scope.input.$save({username: $scope.username, password : $scope.password},function(){
				if(result.response == "success")
				{
					$location.path("/dashboard");
					$rootScope.showLogin = false;
				}
				 else
				{
					 alert("Invalid User !!!"+ $scope.username);
				}
			});
		}else{
			return false;
		}
	};
	
}]);
