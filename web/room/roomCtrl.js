/**
 * Created by oliver on 01/03/15.
 */

/*global angular*/
angular.module('roomApp', [])
    .controller('roomCtrl', ['$scope','$rootScope', '$state', 'roomService', function ($scope, $rootScope, $state, roomService) {
        'use strict';

        $scope.roomNumberU = $rootScope.roomNumberToUpdate;
        $scope.roomNameU = $rootScope.roomTypeToUpdate;
        $scope.roomDimensionU = $rootScope.roomDimensionToUpdate;

        $scope.createRoom = function(){
            roomService.createRoom($scope.roomNumber, $scope.roomType, $scope.roomDimension);
        };
        $scope.readRoom = function(){
            roomService.readRoom($scope.idRoom);
            $state.go('home.roomDisplay');
        };
        $scope.readRoomToUpdate = function(){
            roomService.readRoomToUpdate($scope.idRoomU);
        };
        $scope.updateRoom = function(){
            roomService.updateRoom($scope.idRoomU,$scope.roomNumberU, $scope.roomTypeU, $scope.roomDimensionU);
        };
        $scope.deleteRoom = function(){
            roomService.deleteRoom($scope.idRoomD);
        };
    }])

    .service('roomService', function ($http, $rootScope){
        'use strict';

        function create(roomNumber, roomType, roomDimension){

            $http({
                method: 'GET',
                url: "http://localhost:8080/WebServicesProject/rest/room/create",
                params: {roomNumber:roomNumber, roomType:roomType, roomDimension:roomDimension}
            }).success(function(){
                    window.alert("Room creation success OK");
                }).error(function(){
                    window.alert("Room creation failed");
                });
        }

        function read(idRoom){
            $http({
                method: 'GET',
                url: "http://localhost:8080/WebServicesProject/rest/room/read",
                params: {idRoom: idRoom}
            }).success(function(data){
                    $rootScope.roomNumberSelected = data.roomNumber;
                    $rootScope.roomTypeSelected = data.roomType;
                    $rootScope.roomDimensionSelected = data.roomDimension;
                }).error(function(){
                    window.alert("Room reading failed");
                });
        }

        function readToUpdate(idRoomU){
            $http({
                method: 'GET',
                url: "http://localhost:8080/WebServicesProject/rest/room/readToUpdate",
                params: {idRoomU: idRoomU}
            }).success(function(data){
                    $rootScope.roomNumberToUpdate = data.roomNumber;
                    $rootScope.roomTypeToUpdate = data.roomType;
                    $rootScope.roomDimensionToUpdate = data.roomDimension;
                    window.alert("Room reading success OK");
                }).error(function(){
                    window.alert("Room reading failed");
                });
        }

        function update(idRoomU,roomNumberU, roomTypeU, roomDimensionU){
            $http({
                method: 'GET',
                url :"http://localhost:8080/WebServicesProject/rest/room/update",
                params:{idRoomU:idRoomU,roomNumberU:roomNumberU, roomTypeU:roomTypeU, roomDimensionU:roomDimensionU}
            }).success(function(){
                    window.alert("Room update success");
                }).error(function(){
                    window.alert("Room update failed");
                });
        }

        function remove(idRoomD){
            $http({
                method: 'GET',
                url: "http://localhost:8080/WebServicesProject/rest/room/delete",
                params: {idRoomD: idRoomD}
            }).success(function(){
                    window.alert("Room removal success");
                }).error(function(){
                    window.alert("Room removal failed");
                });
        }

        return {
            createRoom: function (roomNumber, roomType, roomDimension) {
                create (roomNumber, roomType, roomDimension);
            },
            readRoom: function (idRoom) {
                read (idRoom);
            },
            readRoomToUpdate: function (idRoomU) {
                readToUpdate (idRoomU);
            },
            updateRoom: function(idRoomU,roomNumberU, roomTypeU, roomDimensionU){
                update(idRoomU,roomNumberU, roomTypeU, roomDimensionU);
            },
            deleteRoom: function(idRoomD){
                remove(idRoomD);
            }
        };
});