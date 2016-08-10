myController.controller('adminDashBoardCtrl',['$scope','$rootScope','NgTableParams','homeFactory','$location',function($scope,$rootScope,NgTableParams,homeFactory,$location){
	
	$rootScope.advertisementBlock = false;
	
	$rootScope.$watch($rootScope.dialog,function() {
		if($rootScope.dialog!=undefined){
			$rootScope.dialog.close();
		}
	});
	
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
    		homeFactory.deleteCandidate({candidateid: id},function(result){
				if(result.response == "success")
				{
					alert("Successfully Deleted!!!");
					$scope.loadData();
				}
				 else
				{
					 alert("Something went Wrong !!!");
				}
    		}
    		
    		);
    		
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
