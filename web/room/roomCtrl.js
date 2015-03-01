/**
 * Created by oliver on 01/03/15.
 */

/*global angular*/
angular.module('roomApp', [])
    .controller('roomCtrl', ['$scope', '$state', 'roomService', function ($scope, $state, roomService) {
        'use strict';
        $scope.createRoom = function(){
            roomService.createRoom($scope.roomNumber, $scope.roomType, $scope.roomDimension);
        };
        $scope.readRoom = function(){
            roomService.readRoom($scope.idRoom);
        };
        $scope.updateRoom = function(){
            roomService.updateRoom($scope.roomNumberU, $scope.roomTypeU, $scope.roomDimensionU);
        };
        $scope.deleteRoom = function(){
            roomService.deleteRoom($scope.idRoomD);
        };
    }])

    .service('roomService', function ($http){
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
            }).success(function(){
                    window.alert("Room reading success OK");
                }).error(function(){
                    window.alert("Room reading failed");
                });
        }

        function update(roomNumberU, roomTypeU, roomDimensionU){
            $http({
                method: 'GET',
                url :"http://localhost:8080/WebServicesProject/rest/room/update",
                params:{roomNumberU:roomNumberU, roomTypeU:roomTypeU, roomDimensionU:roomDimensionU}
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
            updateRoom: function(roomNumberU, roomTypeU, roomDimensionU){
                update(roomNumberU, roomTypeU, roomDimensionU);
            },
            deleteRoom: function(idRoomD){
                remove(idRoomD);
            }
        };
});