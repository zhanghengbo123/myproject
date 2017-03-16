var loginData = angular.module('login.Service.Data',
    ['restangular']
);

loginData.factory('loginService', function($http,Restangular,$cookieStore) {

    return {


    login:function(user){
       // alert("1234");
            var bra =  Restangular.all('user/login');
            bra.post(user,'',{'Client-Type':'PC'}).then(function(data){

                if(data.m=="LOGIN_FAIL"){
                    //location.href="/transport/login.html";
                    $scope.erreMsm='用户名或密码错误！';
                }else{
                    var newToken = data.d.newToken;
                    var  userID= data.d.userID.split(":");
                
                    $cookieStore.put("userID",userID[0]);
                    $cookieStore.put("userName",userID[1]);
                    $cookieStore.put("User-Token",newToken);
                    $cookieStore.put("uName",userID[2]);
                    location.href="/transport/index.jsp";
                }
            },function(){
                //alert("服务器响应失败！");
                $scope.erreMsm='服务器响应失败！';
            });
        },
        index:function () {

        }
        
    }
});