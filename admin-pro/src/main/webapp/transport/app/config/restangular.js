var app = angular.module('app');
app.config(function (RestangularProvider) {
    RestangularProvider.setBaseUrl('/json');

    var cookie = document.cookie;
    //  alert(cookie);
    // User-Token=%223c3dd850-17ef-46b9-8056-ec688df50de5%22; userID=%223%22; userName=%22admin%22
    var arrCookie = cookie.split("; ");
    var token = '';
    var userId = '';
    var username = '';

    for (var i = 0; i < arrCookie.length; i++) {
        var arr = arrCookie[i].split("=");
        for (j = 0; j < arr.length; j++) {
            // alert(arr[j]);
            if ("User-Token" == arr[j]) {
                token = arr[j + 1];
                break;
            } else if ("userID" == arr[j]) {
                userId = arr[j + 1];
                break;
            } else if ("userName" == arr[j]) {
                username = arr[j + 1];
                break;
            }
        }
    }
    token = token.substr(3, token.length - 6);
    userId = userId.substr(3, userId.length - 6);
    username = username.substr(3, username.length - 6);

    //alert(username)
    RestangularProvider.setFullRequestInterceptor(function (element, operation, route, url, headers, params, httpConfig) {

        // if (token=='') {
        //  alert("请先登录");
        //  window.location.href="/transport/login.html";
        //  }
        return {
            element: element,
            params: params,
            headers: _.extend(headers, {'User-Token': token, 'Client-Type': 'PC'}),
            httpConfig: httpConfig
        };
    });

    RestangularProvider.setResponseInterceptor(function (data, operation, what, url, response, deferred) {
        var status = response.headers('Login-State');
        if (status != null && status != "") {
            if (status == "statu-error") {
                alert("您的账户已在别处登录或者登录失效，请重新登录！");
            } else if (status == "statu-timeout") {
                alert("登录信息已过期");
            }
            location.href = "/login.jsp";
        }
        //return data;
            if (data.c == "0") {
                return data.d;
            } else if (data.c == "2") {
                return data.m;
            } /*else if (data.c = "9") {
                return data;
            }*/ else {
                return data;
        }


    });

});