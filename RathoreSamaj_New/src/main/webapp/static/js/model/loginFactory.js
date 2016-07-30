myApp.factory('loginFactory', function($resource){
	var baseURL = '/RathoreSamaj/user';
	return $resource(baseURL, {}, {
		'save' : {
			method : 'POST',
			url: baseURL+'/login'
		}
	});
});