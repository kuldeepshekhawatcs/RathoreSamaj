myApp.config([ '$routeProvider', function($routeProvider){
$routeProvider.when('/home', {
        templateUrl: 'html/home.html',
        controller: 'homeCtrl'
    });
    $routeProvider.when('/aboutus', {
        templateUrl: 'html/myhome.html',
       
    });
    $routeProvider.when('/register', {
        templateUrl: 'html/register.html',
        controller: 'registerCtrl'
    });
    $routeProvider.when('/mission', {
        templateUrl: 'html/mission.html',
        controller: 'missionCtrl'
    });
    $routeProvider.when('/mission', {
        templateUrl: 'html/mission.html',
        controller: 'missionCtrl'
    });
    $routeProvider.when('/login', {
        templateUrl: 'html/login.html',
        
    });
    $routeProvider.when('/dashboard', {
        templateUrl: '/dashboard.html',
        
    });
    $routeProvider.otherwise({
		redirectTo : '/home'
	});
}]);