'use strict';

myServices.service("fileUploadService",[ '$http', function($http) {
	
	this.serverCall = function(url, formData) {
		var response = $http({
			method	:	"POST",
			headers	: 	{ 'Content-Type': undefined },
	        transformRequest	: angular.identity,
			url		:	url,
			data	:	formData
	     });
		return response;
	};
	
	this.uploadFiles = function(urlPath, formData) {
		return this.serverCall(urlPath, formData);
	}
}]);