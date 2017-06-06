angular.module('CollaborationApp').controller('UserController',function(UserService,RegisterService, REST_URI){

    var me=this;
    me.user = [];

    me.myFriends = [];

    me.friendsCount = [];

    me.myOnlineFriends = [];

    me.countOnlineFriends = [];

    me.fetchMyFriends = function() {
         
          UserService.fetchMyFriends()
            .then (
                function(myFriends) {
                //debugger;
                 me.myFriends =  myFriends;
                 me.friendsCount =  me.myFriends.length;
                },
                function(errResponse) {
                }
            );

     }

     me.fetchOnlineFriends = function(){
        
         console.log('Showing online friends now!');
         UserService.fetchOnlineFriends()
            .then (
                function(onlineFriends) {
                //debugger;
                 me.myOnlineFriends =  onlineFriends;
                 me.countOnlineFriends =  me.myOnlineFriends.length;
                },
                function(errResponse) {
                }
            );
     }

     //logout function
     me.logout = function(){
      RegisterService.logout()
        .then(

          function(message){   
            $location.path('/landingPage');
                me.error=false;
          },
          function(error){
            me.error=true;
          } 
     );
}

    
});