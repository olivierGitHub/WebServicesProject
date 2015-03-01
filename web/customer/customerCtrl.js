/**
 * Created by oliver on 28/02/15.
 */

/*global angular*/
angular.module('customerApp', [])

    .controller('customerCtrl', ['$scope', '$state', 'customerService', function ($scope, $state, customerService) {
        'use strict';
        $scope.createCustomer = function(){
            customerService.createCustomer($scope.firstname, $scope.lastname);
        };
        $scope.readCustomer = function(){
            customerService.readCustomer($scope.idCustomer);
        };
        $scope.updateCustomer = function(){
            customerService.updateCustomer($scope.firstnameU, $scope.lastnameU);
        };
        $scope.deleteCustomer = function(){
            customerService.deleteCustomer($scope.idCustomerD);
        };
    }])

    .service('customerService', function ($http){
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
            }).success(function(){
                    window.alert("Customer reading success OK");
                }).error(function(){
                    window.alert("Customer reading failed");
                });
        }

        function update(firstnameU, lastnameU){
            $http({
                method: 'GET',
                url :"http://localhost:8080/WebServicesProject/rest/customer/update",
                params:{firstnameU:firstnameU, lastnameU:lastnameU}
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
            updateCustomer: function(firstnameU, lastnameU){
                update(firstnameU,lastnameU);
            },
            deleteCustomer: function(idCustomerD){
                remove(idCustomerD);
            }
        };
    }

);