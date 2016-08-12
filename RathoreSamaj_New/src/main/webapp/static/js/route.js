myApp.config([ '$routeProvider', function($routeProvider){
$routeProvider.when('/home', {
        templateUrl: 'html/home.html',
        controller: 'homeCtrl'
    });
    $routeProvider.when('/myhome', {
        templateUrl: 'html/myhome.html',
        controller : 'aboutUsCtrl'
    });
    $routeProvider.when('/register', {
        templateUrl: 'html/register.html',
        controller: 'registerCtrl'
    });
    $routeProvider.when('/dashboard', {
        templateUrl: 'html/dashboard.html',
        controller: 'adminDashBoardCtrl'
    });
    $routeProvider.otherwise({
		redirectTo : '/myhome'
	});
}]);