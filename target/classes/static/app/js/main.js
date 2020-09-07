var modul3TestApp = angular.module("modul3TestApp",["ngRoute"]);

modul3TestApp.service("StanjaService", function($http){
	this.baseUrl = "/api/stanja";
	
	this.getStanja = function(){
		return $http.get(this.baseUrl);
	}
});

modul3TestApp.service("SprintService", function($http){
	this.baseUrl = "/api/sprintovi";
	
	this.getSprintovi = function(){
		return $http.get(this.baseUrl);
	}
});

modul3TestApp.controller("HomeCtrl", function($scope){
	$scope.message="Hello test 3";
});

modul3TestApp.controller("ZadaciCtrl", function($scope, SprintService, StanjaService, $http, $location){
    $scope.zadaci = [];
    $scope.stanja = [];
    $scope.sprintovi = [];
    $scope.pageNum = 0;
    $scope.totalPages = 1;
    
    $scope.newZadatak = {};
	$scope.newZadatak.ime = "";
	$scope.newZadatak.zaduzen = "";
	$scope.newZadatak.bodovi = "";
	$scope.newZadatak.sprint = "";
    $scope.newZadatak.stanje = "";
    
    var config = {params:{}};

    config.params.pageNum = $scope.pageNum;
	
	var getZadaci = function(){
		var promise = $http.get("api/zadaci", config);
		promise.then(
			function success(res){
				$scope.zadaci = res.data;
			},
			function error(res){
				alert("Zadaci nisu dobavljeni");
			}
		);
	}
	
    getZadaci();

    var getStanja = function(){
		var promise = StanjaService.getStanja();
		promise.then(
			function success(res){
				$scope.stanja = res.data;
			},
			function error(res){
				alert("Stanja nisu dobavljeni");
			}
		);
	}
	
    getStanja();

    var getSprintovi = function(){
		var promise = SprintService.getSprintovi();
		promise.then(
			function success(res){
				$scope.sprintovi = res.data;
			},
			function error(res){
				alert("Sprintovi nisu dobavljeni");
			}
		);
	}
	
    getSprintovi();

    $scope.doDelete = function(id){
		var promise = $http.delete("/api/zadaci/" + id);
		promise.then(
			function success(){
                $scope.totalPages = res.headers("totalPages");
				getZadaci();
			},
			function error(){
				alert("Zadatak nije obrisan");
			}
		);
    }
    
    $scope.goToEdit = function(id) {
        $location.path("/zadaci/edit/" + id);
    }

    $scope.changePage = function(direction){
		$scope.pageNum += direction;
		getZadaci();
	}
});

modul3TestApp.config(['$routeProvider', function($routeProvider) {
	$routeProvider
		.when('/', {
			templateUrl : '/app/html/home.html',
			controller: "HomeCtrl"
		})
		.when('/zadaci', {
			templateUrl : '/app/html/zadaci.html'
        })
        .when('/zadaci/edit/:zid', {
			templateUrl : '/app/html/edit-zadatak.html'
		})
		.otherwise({
			redirectTo: '/'
		});
}]);