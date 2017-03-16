angular.module('login').controller('LoginController',
    function ($scope, loginService) {
        $scope.user = {};
        $scope.login = function () {

            loginService.login($scope.user);


        }
    });