myController.controller('adminDashBoardCtrl',['$scope','$rootScope','NgTableParams','homeFactory','$location',function($scope,$rootScope,NgTableParams,homeFactory,$location){
	
	$rootScope.advertisementBlock = false;
	
	/*$scope.users = [{"id":1,"first_name":"Philip","last_name":"Kim","email":"pkim0@mediafire.com","country":"Indonesia","ip_address":"29.107.35.8"},
                    {"id":2,"first_name":"Judith","last_name":"Austin","email":"jaustin1@mapquest.com","country":"China","ip_address":"173.65.94.30"},
                    {"id":3,"first_name":"Julie","last_name":"Wells","email":"jwells2@illinois.edu","country":"Finland","ip_address":"9.100.80.145"},
                    {"id":4,"first_name":"Gloria","last_name":"Greene","email":"ggreene3@blogs.com","country":"Indonesia","ip_address":"69.115.85.157"},
                    {"id":50,"first_name":"Andrea","last_name":"Greene","email":"agreene4@fda.gov","country":"Russia","ip_address":"128.72.13.52"}];*/

	
	$scope.loadData = function(){
		homeFactory.get(function(result){
			$scope.candidateList = result.candidateDTOList;
			$scope.displayRecords();
		});
	}
	
	
	
	$scope.loadData();
	
	$scope.displayRecords = function(){  
        $scope.usersTable = new NgTableParams({
			page: 1,
			count : $scope.candidateList.length
		}, { 
			filterDelay: 0,
			data: $scope.candidateList,
		});
   };
    	$scope.updateData = function(data){
    	  $location.path('/register').search({candidateid: data.id});
    	   
    	}
    	
    	$scope.deleteData = function(id){
     	   // send request to delete data
    		alert("Under Construction!!!!")   	   
     	}
    
    	$scope.showConfirm = function() {
    		   var confirmPopup = $ionicPopup.confirm({
    		     title: 'Delete',
    		     template: 'Are you sure you want to delete this item?'
    		   });

    		   confirmPopup.then(function(res) {
    		     if(res) {
    		       // Code to be executed on pressing ok or positive response
    		       // Something like remove item from list
    		     } else {
    		       // Code to be executed on pressing cancel or negative response
    		     }
    		   });
    		 };
}]);
