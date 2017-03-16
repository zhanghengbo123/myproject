angular.module('app').config(['$routeProvider', function($routeProvider) {
    $routeProvider.
    when('/', {
        controller: 'Trans',
        // resolve: {
        //     menus: ["MultiMenuLoader", function(MultiMenuLoader) {
        //         return MultiMenuLoader();
        //     }]
        // },
        templateUrl:'views/main/main.html'
    }).otherwise({
        redirectTo:'/'
    });
}]);

