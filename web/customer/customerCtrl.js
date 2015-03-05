/**
 * Created by oliver on 28/02/15.
 */

/*global angular*/
angular.module('customerApp', [])

    .controller('customerCtrl', ['$scope', '$rootScope', '$state', 'customerService', function ($scope, $rootScope, $state, customerService) {
        'use strict';
        $scope.firstnameU = $rootScope.customerFirstnameToUpdate;
        $scope.lastnameU = $rootScope.customerLastnameToUpdate;

        $scope.createCustomer = function(){
            customerService.createCustomer($scope.firstname, $scope.lastname);
        };
        $scope.readCustomer = function(){
            customerService.readCustomer($scope.idCustomer);
            $state.go('home.customerDisplay');
        };
        $scope.readCustomerToUpdate = function(){
            customerService.readCustomerToUpdate($scope.idCustomerU);
        };
        $scope.updateCustomer = function(){
            customerService.updateCustomer($scope.idCustomerU,$scope.firstnameU, $scope.lastnameU);
        };
        $scope.deleteCustomer = function(){
            customerService.deleteCustomer($scope.idCustomerD);
        };
    }])

    .service('customerService', function ($http, $rootScope){
        'use strict';
        function create(firstname, lastname){
            $http({
                method: 'GET',
                url: "http://localhost:8080/WebServicesProject/rest/customer/create",
                params: {firstname: firstname, lastname: lastname}
            }).success(function(){
                    window.alert("Customer creation success OK");
            }).error(function(){
                    window.alert("Customer creation failed");
            });
        }

        function read(idCustomer){
            $http({
                method: 'GET',
                url: "http://localhost:8080/WebServicesProject/rest/customer/read",
                params: {idCustomer: idCustomer}
            }).success(function(data){
                    $rootScope.customerIdSelected = data.idCustomer;
                    $rootScope.customerFirstnameSelected = data.firstName;
                    $rootScope.customerLastnameSelected = data.lastName;
                }).error(function(){
                    window.alert("Customer reading failed");
                });
        }

        function readToUpdate(idCustomerU){
            $http({
                method: 'GET',
                url: "http://localhost:8080/WebServicesProject/rest/customer/readToUpdate",
                params: {idCustomerU: idCustomerU}
            }).success(function(data){
                    $rootScope.customerFirstnameToUpdate = data.firstName;
                    $rootScope.customerLastnameToUpdate = data.lastName;
                }).error(function(){
                    window.alert("Customer reading failed");
                });
        }

        function update(idCustomerU,firstnameU, lastnameU){
            $http({
                method: 'GET',
                url :"http://localhost:8080/WebServicesProject/rest/customer/update",
                params:{idCustomerU:idCustomerU,firstnameU:firstnameU, lastnameU:lastnameU}
            }).success(function(){
                    window.alert("Customer update success");
            }).error(function(){
                    window.alert("Customer update failed");
            });
        }

        function remove(idCustomerD){
            $http({
                method: 'GET',
                url: "http://localhost:8080/WebServicesProject/rest/customer/delete",
                params: {idCustomerD: idCustomerD}
            }).success(function(){
                    window.alert("Customer removal success");
            }).error(function(){
                    window.alert("Customer removal failed");
            });
        }

        return {
            createCustomer: function (firstname, lastname) {
                create (firstname, lastname);
            },
            readCustomer: function (idCustomer) {
                read (idCustomer);
            },
            readCustomerToUpdate: function (idCustomerU) {
                readToUpdate (idCustomerU);
            },
            updateCustomer: function(idCustomerU,firstnameU, lastnameU){
                update(idCustomerU,firstnameU,lastnameU);
            },
            deleteCustomer: function(idCustomerD){
                remove(idCustomerD);
            }
        };
    }

);