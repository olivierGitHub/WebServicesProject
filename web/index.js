/**
 * Created by oliver on 28/02/15.
 */

/* global angular */
angular.module('app', ['ui-router'])

    .config(function ($stateProvider, $urlRouterProvider){
        'use strict';
       /* var customer = {
            name: 'customer',  //mandatory
            url: '/customer',
            templateUrl: 'customer.html'
        }

        var createCustomer = {
            name: 'customer.create', //mandatory. This counter-intuitive requirement addressed in issue #368
            parent: customer,  //mandatory
            url: '/create',
            templateUrl: 'customer.create.html'
        }

        var readCustomer = {
            name: 'customer.read', //mandatory. This counter-intuitive requirement addressed in issue #368
            parent: customer,  //mandatory
            url: '/read',
            templateUrl: 'customer.read.html'
        }*/


        $urlRouterProvider.otherwise("/customer");

        $stateProvider
            .state('customer', {
                url: '/customer',
                templateUrl: 'customer/customer.html'
            })
            .state('customer.create', {
                parent: customer,  //mandatory
                url: '/create',
                templateUrl: 'customer/customer.create.html'
            })
            .state('customer.read', {
                parent: customer,  //mandatory
                url: '/read',
                templateUrl: 'customer/customer.read.html'
            });



    })



    .controller('myCtrl', function(){

});