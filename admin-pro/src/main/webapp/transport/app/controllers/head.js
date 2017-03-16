angular.module('app')
    .controller('HeadController',
            function($scope,clientservice,$rootScope){
                $scope.user = {};
                $scope.userInfo = function () {
                    var userId = $rootScope.clientID;
                 clientservice.userInfo(userId,function (data) {
                     $scope.user = data;
                 });
                }
            }
    );