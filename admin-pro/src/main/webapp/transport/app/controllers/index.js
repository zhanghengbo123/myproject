angular.module('app')
    .controller('IndexController', ['$scope',
        function($scope,$http,Restangular,clientservice,$location){
            $scope.init = function(){
               $http.get('app/controllers/user.json') .success(function (response) {
                   $scope.ss = response.user;
               });;

            }
            $scope.init();
            $location.path('/toMain');
        }
    ]);