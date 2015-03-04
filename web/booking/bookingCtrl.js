/**
 * Created by oliver on 01/03/15.
 */
/*global angular*/
angular.module('bookingApp', [])
    .controller('bookingCtrl', ['$scope', '$rootScope', '$state', 'bookingService', function ($scope, $rootScope, $state, bookingService) {
        'use strict';
        $scope.listBooking = [];
        $scope.createBooking = function(){
            bookingService.createBooking($scope.bookingName,$scope.bookingRoom,$scope.arrivalDate,$scope.departureDate);
        };
        $scope.readBooking = function(){
            bookingService.readBooking($scope.idBooking);
        };
        $scope.updateBooking = function(){
            bookingService.updateBooking($scope.bookingNameU,$scope.bookingRoomU,$scope.arrivalDateU,$scope.departureDateU);
        };
        $scope.deleteBooking = function(){
            bookingService.deleteBooking($scope.idBookingD);
        };
        $scope.readAllBooking = function(){
            bookingService.readAllBooking();
            $state.go('home.bookingList');
        };
    }])

    .service('bookingService', function ($http, $rootScope){
        'use strict';
        function create(bookingName, bookingRoom, arrivalDate, departureDate){
            $http({
                method: 'GET',
                url: "http://localhost:8080/WebServicesProject/rest/booking/create",
                params: {bookingName:bookingName,bookingRoom:bookingRoom, arrivalDate:arrivalDate, departureDate:departureDate}
            }).success(function(){
                    window.alert("Booking creation success OK");
                }).error(function(){
                    window.alert("Booking creation failed");
                });
        }

        function read(idBooking){
            $http({
                method: 'GET',
                url: "http://localhost:8080/WebServicesProject/rest/booking/read",
                params: {idBooking: idBooking}
            }).success(function(){
                    window.alert("Booking reading success OK");
            }).error(function(){
                    window.alert("Booking reading failed");
            });
        }

        function update(bookingNameU, bookingRoomU, arrivalDateU, departureDateU){
            $http({
                method: 'GET',
                url :"http://localhost:8080/WebServicesProject/rest/booking/update",
                params:{bookingNameU:bookingNameU, bookingRoomU:bookingRoomU, arrivalDateU:arrivalDateU, departureDateU:departureDateU}
            }).success(function(){
                    window.alert("Booking update success");
                }).error(function(){
                    window.alert("Booking update failed");
                });
        }

        function remove(idBookingD){
            $http({
                method: 'GET',
                url: "http://localhost:8080/WebServicesProject/rest/booking/delete",
                params: {idBookingD: idBookingD}
            }).success(function(){
                    window.alert("Booking removal success");
                }).error(function(){
                    window.alert("Booking removal failed");
                });
        }

        function readAll(){
            $http({
                method: 'GET',
                url: "http://localhost:8080/WebServicesProject/rest/booking/readALL"
            }).success(function(data){
                    $rootScope.listBooking = data;
                }).error(function(){
                    window.alert("Booking read ALL failed");
                });
        }

        return {
            createBooking: function (bookingName, bookingRoom,arrivalDate, departureDate) {
                create (bookingName, bookingRoom, arrivalDate, departureDate);
            },
            readBooking: function (idCustomer) {
                read (idCustomer);
            },
            updateBooking: function(bookingNameU, bookingRoomU, arrivalDateU, departureDateU){
                update(bookingNameU, bookingRoomU, arrivalDateU, departureDateU);
            },
            deleteBooking: function(idCustomerD){
                remove(idCustomerD);
            },
            readAllBooking: function(){
                readAll();
            }
        };
    }
);