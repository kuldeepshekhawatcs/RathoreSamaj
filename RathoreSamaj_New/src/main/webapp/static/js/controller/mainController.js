myController.controller('mainCtrl',['$scope','$rootScope','ngDialog','$location',function($scope,$rootScope,ngDialog,$location){
	
	$rootScope.advertisementBlock = true;
	
	$scope.openLoginDialog = function(){
		$rootScope.dialog = ngDialog.open({
		    template: 'html/login.html',
		    controller: 'loginCtrl',
		    closeByDocument: false,
		    showClose: false,
		    scope: $scope
		});
	};
			
	$scope.logout = function(){
		$rootScope.showLogin = true;
		$location.path('/home').search('');
	};
	
}]);
