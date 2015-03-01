/**
 * Created by oliver on 28/02/15.
 */

angular.module('customerApp', [])
    .controller('customerCtrl', ['$scope', '$state', 'customerService', function ($scope, $state, customerService) {
        $scope.createCustomer = function(){
            customerService.createCustomer($scope.firstname, $scope.lastname);
        };
    }])

    .service('customerService', function ($http, $rootScope){
        function create(firstname, lastname){
            /*$http.get('http://localhost:8080/WebServicesProject/rest/customer/create').
                success(function() {
                    console.log("Customer creation success")
                })}*/

            $http({
                method: 'GET',
                url: "http://localhost:8080/WebServicesProject/rest/customer/create",
                params: {firstname: firstname, lastname: lastname}
            }).success(function(){
                    console.log("Customer creation success OK")
            }).error(function(){
                    console.log("Customer creation failed")
            })}

        return {
            createCustomer: function (firstname, lastname) {
                create (firstname, lastname);
            }
        };
    }

);