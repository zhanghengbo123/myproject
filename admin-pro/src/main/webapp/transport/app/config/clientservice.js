/**
 * Created by likai on 2016/9/29.
 */
       var app_service =  angular.module("app.service",[]);
        app_service.factory('clientservice',function($rootScope,Restangular){
            var cookie = document.cookie;
            var arrCookie=cookie.split("; ");
            var token = '';
            var userId = '';
            var username = '';
            var uname = '';
            for(var i=0; i<arrCookie.length;i++){
                var arr=arrCookie[ i].split("=");
                for(j=0;j<arr.length;j++){
                    // alert(arr[j]);
                    if("User-Token"==arr[j]){
                        token=arr[j+1];
                        break;
                    }else if("userID"==arr[j]){
                        userId = arr[j+1];
                        break;
                    }else if("userName"==arr[j]){
                        username = arr[j+1];
                        break;
                    }else if("uName"==arr[j]){
                        uname = arr[j+1];
                        break;
                    }
                }
            }
                    return {
                    token:$rootScope.token=token.substr(3,token.length-6),
                    clientID:$rootScope.clientID=userId.substr(3,userId.length-6),
                    clientName:$rootScope.clientName=username.substr(3,username.length-6),
                    userInfo:function (userId,callback) {
                            var user = Restangular.one('/networkuser/user/'+userId);
                            user.get('').then(function (data) {
                                callback(data);
                            });
                    }
                };
           
        });