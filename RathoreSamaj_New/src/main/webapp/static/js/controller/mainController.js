myController.controller('mainCtrl',['$scope','$rootScope','ngDialog',function($scope,$rootScope,ngDialog){
	
	$rootScope.advertisementBlock = true;
	
	$scope.openLoginDialog = function(){
		ngDialog.open({
		    template: 'html/login.html',
		    controller: 'loginCtrl',
		    closeByDocument: false,
		    showClose: false,
		    scope: $scope
		});
	};
			
			
}]);
