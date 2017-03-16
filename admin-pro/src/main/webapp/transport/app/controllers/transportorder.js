var order = angular.module("transportorder",['restangular']);

order.controller("Trans", function($rootScope,$scope,$http,Restangular,clientservice) {
    // 个人运输单数量
    //var username = $("#username").val();
        //alert(username);

    //取出用户名和id
    var username =  clientservice.clientName;
    var userid =  clientservice.clientID;

    $scope.init = function () {
        var getMon = Restangular.one('mytransport/order',username);
        getMon.get("").then(function(data) {
            $scope.tsOrder = data;

        });
    }
    $scope.init();

    // 个人的客户
    $scope.getCustomers = function () {
        var customer = Restangular.one('mycustomers',userid);
        customer.get("").then(function(data) {
            $scope.customers = data;

        });
    }
    $scope.getCustomers();
    
    // 完成的订单数
    $scope.getSuccessOrder = function(){
        var successOrder = Restangular.one('complete/orders');
        successOrder.get("").then(function(data) {
            $scope.itemsComplete = data;

        });
    }
    $scope.getSuccessOrder();

    // 客户报价单数量

    $scope.finish = function(){
        var finishOrder = Restangular.one('price',userid);
        finishOrder.get("").then(function(data) {
            $scope.aa = data;
        });
    }
    $scope.finish();




    
});


