var myApp = angular.module('myApp', ['ngRoute','myController','ngResource','myServices']);

var myController = angular.module('myController',['ngFileUpload']);

/* Services */
var myServices = angular.module('myServices', []);


/*myApp.config(function($httpProvider) {
	$httpProvider.interceptors.push('APIInterceptor');
	$httpProvider.defaults.withCredentials = true;
},function($typeaheadProvider) {
	  angular.extend($typeaheadProvider.defaults, {
		    animation: 'am-flip-x',
		    minLength: 2,
		    limit: 8
		  });
		});*/
