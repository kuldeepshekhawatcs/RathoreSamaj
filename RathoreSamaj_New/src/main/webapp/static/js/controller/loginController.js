myController.controller('loginCtrl',['$scope','$location',function($scope,$location){
	
	$scope.save = function(){
		$location.path("/dashboard");
	};
			
			
}]);
