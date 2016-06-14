myController.controller('homeCtrl',['$scope','homeFactory',function($scope,homeFactory){
	
	homeFactory.get(function(result){
		$scope.candidateList = result.candidateDTOList;
	});
	
	$scope.ageList = [];
	
	for(var i = 18; i <= 75; i++) {
		$scope.ageList.push({value : i});
	};
	
	$scope.search = function(){
		homeFactory.query({gender:$scope.gender,fromAge: $scope.fromAge,toAge: $scope.toAge,location: $scope.location, annualIncome: $scope.annualIncome},function(result){
			$scope.candidateList = result.candidateDTOList;
		});
	}
}]);
