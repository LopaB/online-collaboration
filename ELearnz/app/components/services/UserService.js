angular.module('CollaborationApp').service('UserService',function($http,$q,$rootScope,$cookies,$location,REST_URI){

    //fetch user's friends
        this.fetchMyFriends=function() {
             var deferred = $q.defer();
             var user = $rootScope.user;
             console.log(user);
            var userId = user.userId;
              $http.get(REST_URI + '/my/friends/' + userId)
                .then (
                    function(response) {
                        deferred.resolve(response.data);
                    },
                    function(errResponse) {
                        deferred.reject(errResponse);
                    }
                );
                return deferred.promise;
        }

        //fetch my online friends
         this.fetchOnlineFriends=function() {
             var deferred = $q.defer();

             var user = $rootScope.user;
             var userId = user.userId;
              $http.get(REST_URI + '/my/online/friends/' + userId)
                .then (
                    function(response) {
                        deferred.resolve(response.data);
                    },
                    function(errResponse) {
                        deferred.reject(errResponse);
                    }
                );
                return deferred.promise;
        }

        //logout function
     this.logout=function(){
        //debugger;
        var deferred=$q.defer();
        var user=$rootScope.user;
        $http.post(REST_URI+'/logout',user).then(
            function(response){
                $cookies.putObject('user', undefined);
                userIsAuthenticated = false;
                role = 'GUEST';
                deferred.resolve(response);
                 $location.path('/landingPage');
            },
            function (error){
                deferred.reject(error);
                console.log(error);
            }
        );
        return deferred.promise;
    }
       
});