chat.controller('UserListController', ['$scope', 'UserService', function ($scope, UserService) {
    $scope.users = [];

    function init() {
        $scope.users = UserService.online().then(function () {
            UserService.all().then(function (response) {
                $scope.users = response.data;
            })
        });
    }

    init();
}]);