var app=angular.module('app',['ngRoute']);

app.config(function($routeProvider) {
    $routeProvider.otherwise({
        redirectTo:"/"
    });
});

app.controller(function($scope,$http){
});