myApp.factory('homeFactory', function($resource){
	var baseURL = '/RathoreSamaj/register';
	return $resource(baseURL, {}, {
		'get' : {
			method : 'GET',
			url: baseURL+'/getcandidate'
		},
		'query' : {
			method : 'GET',
			url: baseURL+'/search'
		},
	});
});