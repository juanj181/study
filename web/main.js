app.config(function($routeProvider) {
    $routeProvider.when("/",{
        templateUrl:"main.html",
        controller:"MainCtrl"
    });
    
});
app.controller('MainCtrl',  function($scope,$http) {
    $scope.listaPreguntas=[];
    $scope.nombre=null;
    $scope.idPregunta=null;
    
    $scope.verPreguntas=function($scope,$http){
        $http.get("ExamenRecuperacionFinal/api/pregunta").success(function(result){
            $scope.listaPreguntas=result;
        });
    };
    
    $scope.nuevoJuego=function($scope,$http,$location){
        $http.post("ExamenRecuperacionFinal/api/juego/"+$scope.nombre).success(function(result){
            $scope.idPregunta=result;
        });
        $location.path("/responder.html");
    };
});