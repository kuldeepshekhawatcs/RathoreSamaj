myApp.factory('registerFactory', function($resource){
	return $resource('/serverURL', {}, {
		'get' : {
			method : 'GET',
			url : 'json/employee.json'
		},
		'save' : {
			method : 'POST',
			headers: [{'Content-Type': 'application/json'}]
		},
		'delete' : {
			method : 'DELETE'
		}
	});
});