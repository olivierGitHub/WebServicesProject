/**
 * Created by oliver on 28/02/15.
 */

/* global angular */
angular.module('myApp', ['ui.router', 'customerApp', 'roomApp', 'bookingApp', 'homeApp'])

    .config(function ($urlRouterProvider, $stateProvider){
        'use strict';

        $urlRouterProvider.otherwise("/home");

        $stateProvider
            .state('home', {
                url: '/home',
                templateUrl: 'home/home.html'
            })
            .state('home.customer', {
                url: '/customer',
                templateUrl: 'customer/customer.html'
            })
            .state('home.customerDisplay', {
                url: '/customerDisplay',
                templateUrl: 'customer/customerDisplay.html'
            })
            .state('home.room', {
                url: '/room',
                templateUrl: 'room/room.html'
            })
            .state('home.roomDisplay', {
                url: '/roomDisplay',
                templateUrl: 'room/roomDisplay.html'
            })
            .state('home.booking', {
                url: '/booking',
                templateUrl: 'booking/booking.html'
            })
            .state('home.bookingDisplay', {
                url: '/bookingDisplay',
                templateUrl: 'booking/bookingDisplay.html'
            })
            .state('home.bookingList', {
                url: '/bookingList',
                templateUrl: 'booking/bookingList.html'
            });
    });