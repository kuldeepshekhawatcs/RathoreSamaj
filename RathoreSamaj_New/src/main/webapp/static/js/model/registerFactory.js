myApp.factory('registerFactory', function($resource){
	var baseURL = '/RathoreSamaj/register';
	return $resource(baseURL, {}, {
		'delete' : {
			method : 'DELETE'
		},
		'getcandiatedetailbyid':{
			method : 'GET',
			url : baseURL+'/getcandiatedetailbyid'
		}
	});
});