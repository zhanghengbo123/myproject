angular.module('login').config(
    ['$routeProvider',
        function($routeProvider) {
            $routeProvider.
            when('/', {
                controller: 'LoginController',
                //templateUrl:'index.jsp'
            })
        }]);
/*
angular.module('login').config(function(RestangularProvider) {
    RestangularProvider.setBaseUrl('/user/');
});


angular.module('login').config(["$cookiesProvider",cookiesFn ])
function cookiesFn($cookiesProvider) {
    $cookiesProvider.defaults = {
        path: yourPath,
        domain: yourDomain,
        expires: expireDate,
        secure: false
    };
}*/
