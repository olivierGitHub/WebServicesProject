/**
 * Created by oliver on 01/03/15.
 */

angular.module('bookingApp', [])
    .controller('bookingCtrl', ['$scope', '$state', 'bookingService', function ($scope, $state, bookingService) {
        $scope.createBooking = function(){
            bookingService.createBooking($scope.bookingName,$scope.arrivalDate,$scope.departureDate);
        };
        $scope.readBooking = function(){
            bookingService.readBooking($scope.idBooking);
        };
        $scope.updateBooking = function(){
            bookingService.updateBooking($scope.bookingNameU,$scope.arrivalDateU,$scope.departureDateU);
        };
        $scope.deleteBooking = function(){
            bookingService.deleteBooking($scope.idBookingD);
        }
    }])

    .service('bookingService', function ($http, $rootScope){
        function create(bookingName, arrivalDate, departureDate){
            $http({
                method: 'GET',
                url: "http://localhost:8080/WebServicesProject/rest/booking/create",
                params: {bookingName:bookingName, arrivalDate:arrivalDate, departureDate:departureDate}
            }).success(function(){
                    console.log("Booking creation success OK")
                }).error(function(){
                    console.log("Booking creation failed")
                })}

        function read(idBooking){
            $http({
                method: 'GET',
                url: "http://localhost:8080/WebServicesProject/rest/booking/read",
                params: {idBooking: idBooking}
            }).success(function(){
                    console.log("Booking reading success OK")
            }).error(function(){
                    console.log("Booking reading failed")
            })}

        function update(bookingNameU, arrivalDateU, departureDateU){
            $http({
                method: 'GET',
                url :"http://localhost:8080/WebServicesProject/rest/booking/update",
                params:{bookingNameU:bookingNameU, arrivalDateU:arrivalDateU, departureDateU:departureDateU}
            }).success(function(){
                    console.log("Booking update success");
                }).error(function(){
                    console.log("Booking update failed");
                })
        }

        function remove(idBookingD){
            $http({
                method: 'GET',
                url: "http://localhost:8080/WebServicesProject/rest/booking/delete",
                params: {idBookingD: idBookingD}
            }).success(function(){
                    console.log("Booking removal success");
                }).error(function(){
                    console.log("Booking removal failed");
                })
        }

        return {
            createBooking: function (bookingName, arrivalDate, departureDate) {
                create (bookingName, arrivalDate, departureDate);
            },
            readBooking: function (idCustomer) {
                read (idCustomer);
            },
            updateBooking: function(bookingNameU, arrivalDateU, departureDateU){
                update(bookingNameU, arrivalDateU, departureDateU)
            },
            deleteBooking: function(idCustomerD){
                remove(idCustomerD)
            }
        };
    }
);