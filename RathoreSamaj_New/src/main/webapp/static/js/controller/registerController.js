myController.controller('registerCtrl',['$scope','Upload','registerFactory','fileUploadService','$location','$rootScope',function($scope,Upload,registerFactory,fileUploadService,$location,$rootScope){
	
			$rootScope.advertisementBlock = true;
			$scope.input = new registerFactory();
			$scope.dateList = [];
			$scope.monthList = [];
			$scope.yearList = [];
			
			for(var i = 1; i <= 31; i++) {
				$scope.dateList.push({value : i});
			};
			for(var i = 1; i <= 12; i++) {
				$scope.monthList.push({value : i});
			};
			for(var i = 1998; i >= 1900; i--) {
				$scope.yearList.push({value : i});
			};
			$scope.save = function(){
				var dob = $scope.date+"/"+$scope.month+"/"+$scope.year;
				$scope.input.dob = dob;
				var formData = new FormData();
					 formData.append('files', $scope.picFile);

				formData.append("register",angular.toJson($scope.input));
				fileUploadService.uploadFiles('/RathoreSamaj/register/addcandidate', formData).success(function(response){
					if(response=="success"){
						alert("Registerd Succesfully");
						$location.path('/home');
					}
				    	}).error(function(result){
				    	});
			};
			
			var searchObject = $location.search();
			if(searchObject!=undefined && searchObject!='' && searchObject.candidateid!=''){
				registerFactory.getcandiatedetailbyid({candidateId:searchObject.candidateid}, function(result){
						$scope.input = result;
						var dob = result.dob;
						if(dob!=''){
							dob  = dob.split('/');
							$scope.date = parseInt(dob[0]);
							$scope.month = parseInt(dob[1]);
							$scope.year = parseInt(dob[2]);
						}
				});
			}
}]);
