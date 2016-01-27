chat.factory('UserService', ['$http', function ($http) {
    var userService = {};

    userService.online = function () {
        return $http.get('/user/online');
    };

    userService.offline = function () {
        return $http.get('/user/offline');
    };

    userService.all = function () {
        return $http.get('/user/all');
    };

    return userService;
}]);
