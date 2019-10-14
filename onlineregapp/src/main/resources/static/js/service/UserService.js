'use strict';

angular.module('onlineRegistrationService', []).factory('UserService', ["$http", function($http) {

    var service = {};

    service.getUserByRecordId = function(userRecordId) {

        var url = 'http://localhost:8080/application/user/' + userRecordId;

        return $http.get(url);
    };

    service.saveUser = function(userDto) {

        return $http.post("http://localhost:8080/application/registerUser", userDto);
    };

    service.getRegisteredUsers = function() {

        return $http.get("http://localhost:8080/application/registeredUsers");
    };

    return service;
}]);