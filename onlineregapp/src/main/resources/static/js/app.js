angular.module('onlineRegistrationApp', ['ngMaterial', 'ngMessages', 'onlineRegistrationService'])
    .controller('OnlineRegistrationCtrl', ['$scope', 'UserService', function ($scope, UserService) {

        $scope.registeredUsers = [];
        $scope.displayedColumns = ['Names', 'ID Number', 'Date Registered'];
        $scope.selectedValue = 'registration';
        $scope.message = '';
        $scope.fetchRegisteredUsers = function () {
            UserService.getRegisteredUsers().then(function (value) {
                console.log('Http response code' + value.status);
                if (value.status === 200) {
                    $scope.registeredUsers = value.data;
                }
            });
        };

        $scope.saveNewUser = function () {

            var userDto = {
                userFullName: this.names + " " + this.surname,
                userIdNumber: this.idNumber
            };

            if (userDto.userFullName !==undefined && userDto.userIdNumber!==undefined){
                UserService.saveUser(userDto).then(function (value) {
                    console.log('Http response code' + value.status);
                    if (value.data === true) {
                        $scope.fetchRegisteredUsers();
                        alert('Online registration successful.');
                        this.registrationForm.reset();                }
                    else {
                        alert('Online registration failed - ID number: [userDto.userIdNumber] is already registered.');
                    }
                });
            }
            else {
                alert('Online registration failed.');
            }
        };

        $scope.clearFields = function () {

            this.registrationForm.$valid;
            this.registrationForm.$setPristine();
            this.registrationForm.$setUntouched();
        };

        $scope.selectedStatusEvent = function (){

            if (this.selectedValue === ''){
                this.selectedValue = $scope.selected;
            }
        }
    }]);