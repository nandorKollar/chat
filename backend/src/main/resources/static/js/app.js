var chat = angular.module('chatApp', []);

chat.filter('online', function() {
    return function(input) {
        return input ? 'online' : 'offline';
    };
});