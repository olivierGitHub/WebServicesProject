/**
 * Created by oliver on 28/02/15.
 */

angular.module('customerApp', [])
    .controller('customerCtrl', ['$scope', '$state', 'customerService', function ($scope, $state, customerService) {
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
        }
    }])

    .service('customerService', function ($http, $rootScope){
        function create(firstname, lastname){
            $http({
                method: 'GET',
                url: "http://localhost:8080/WebServicesProject/rest/customer/create",
                params: {firstname: firstname, lastname: lastname}
            }).success(function(){
                    console.log("Customer creation success OK");
            }).error(function(){
                    console.log("Customer creation failed");
            })}

        function read(idCustomer){
            $http({
                method: 'GET',
                url: "http://localhost:8080/WebServicesProject/rest/customer/read",
                params: {idCustomer: idCustomer}
            }).success(function(){
                    console.log("Customer reading success OK");
                }).error(function(){
                    console.log("Customer reading failed");
                })}

        function update(firstnameU, lastnameU){
            $http({
                method: 'GET',
                url :"http://localhost:8080/WebServicesProject/rest/customer/update",
                params:{firstnameU:firstnameU, lastnameU:lastnameU}
            }).success(function(){
                    console.log("Customer update success");
            }).error(function(){
                    console.log("Customer update failed");
            })
        }

        function remove(idCustomerD){
            $http({
                method: 'GET',
                url: "http://localhost:8080/WebServicesProject/rest/customer/delete",
                params: {idCustomerD: idCustomerD}
            }).success(function(){
                    console.log("Customer removal success");
            }).error(function(){
                    console.log("Customer removal failed");
            })
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