app.config(function($routeProvider) {
    $routeProvider.when("/responder/",{
        templateUrl:"responder.html",
        controller:"ResponderCtrl"
    });
    
});
app.controller('ResponderCtrl', function($scope,$http) {
    $scope.respuesta=null;
    $scope.responder=function($scope,$http){
        $http.put("ExamenRecuperacion/api/juego",$scope.respuesta).succes(function(result){
            alert(result.idPreguntaActual+"---"+result.correcta);
        }).error(function(result){
            alert(result.idPreguntaActual+"---"+result.correcta);
        });
    }; 
});