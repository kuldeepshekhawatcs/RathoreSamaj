myApp.config([ '$routeProvider', function($routeProvider){
$routeProvider.when('/home', {
        templateUrl: 'html/home.html',
        controller: 'homeCtrl'
    });
    $routeProvider.when('/aboutus', {
        templateUrl: 'html/aboutUs.html',
        controller: 'aboutUsCtrl'
    });
    $routeProvider.when('/register', {
        templateUrl: 'html/register.html',
        controller: 'registerCtrl'
    });
    $routeProvider.when('/mission', {
        templateUrl: 'html/mission.html',
        controller: 'missionCtrl'
    });
    $routeProvider.otherwise({
		redirectTo : '/home'
	});
}]);