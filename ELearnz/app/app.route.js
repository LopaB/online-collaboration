window.routes={

    "/landingPage":{
        templateUrl:'app/components/views/landingPage.html',
        controller: 'BasicController',
        controllerAs: 'basicCtrl',
        requiredLogin:false,
        roles:['USER','ADMIN']
    },
     "/about":{
        templateUrl:'app/components/views/about.html',
        controller: 'BasicController',
        controllerAs: 'basicCtrl',
        requiredLogin:false,
        roles:['USER','ADMIN']
    },
    "/contact":{
        templateUrl:'app/components/views/contact.html',
        controller: 'BasicController',
        controllerAs: 'basicCtrl',
        requiredLogin:false,
        roles:['USER','ADMIN']
    },
    
    "/register":{
        templateUrl:'app/components/views/register.html',
        controller: 'RegisterController',
        controllerAs: 'regCtrl',
        requiredLogin:false,
        roles:['USER','ADMIN']
    },
    "/login":{
        templateUrl:'app/components/views/login.html',
        controller: 'RegisterController',
        controllerAs: 'regCtrl',
        requiredLogin:false,
        roles:['USER','ADMIN']
    },
    "/home":{
        templateUrl:'app/components/views/home.html',
        controller: 'UserController',
        controllerAs: 'userCtrl',
        requiredLogin:true,
        roles:['USER']
    },
    "/homeAdmin":{
        templateUrl:'app/components/views/homeAdmin.html',
        controller: 'UserController',
        controllerAs: 'userCtrl',
        requiredLogin:true,
        roles:['ADMIN']
    },
     "/viewUsers":{
        templateUrl:'app/components/views/viewUsers.html',
        controller: 'RegisterController',
        controllerAs: 'regCtrl',
        requiredLogin:true,
        roles:['USER','ADMIN']

    },
     //For accepting requests of user
    "/requests/users": {
        templateUrl : 'app/components/views/userActivation.html',
        controller : 'RequestController',
        controllerAs : 'requestCtrl',
        requireLogin: true,
        roles: ['Super_Admin', 'ADMIN']
    },
    "/requests/blogs":{
        templateUrl:'app/components/views/activateBlog.html',
        controller: 'RequestController',
        controllerAs: 'requestCtrl',
        requiredLogin:true,
        roles:['Super_Admin', 'ADMIN']

    },
    "/blog":{
        templateUrl:'app/components/views/viewBlog.html',
        controller: 'BlogController',
        controllerAs: 'blogCtrl',
        requiredLogin:true,
        roles:['USER','ADMIN']

    },
    "/createblog":{
        templateUrl:'app/components/views/createBlog.html',
        controller: 'BlogController',
        controllerAs: 'blogCtrl',
        requiredLogin:true,
        roles:['USER','ADMIN']

    },
    "/myblog":{
        templateUrl:'app/components/views/myBlog.html',
        controller: 'BlogController',
        controllerAs: 'blogCtrl',
        requiredLogin:true,
        roles:['USER']

    },
    "/blog/:blogId":{
        templateUrl:'app/components/views/singleBlog.html',
        controller: 'BlogController',
        controllerAs: 'blogCtrl',
        requiredLogin:true,
        roles:['ADMIN','USER']

    },
    "/manageblog":{
        templateUrl:'app/components/views/manageBlog.html',
        controller: 'AdminController',
        controllerAs: 'adminCtrl',
        requiredLogin:true,
        roles:['ADMIN','USER']

    },
    //For viewing list of all site's members
    "/member/list": {
        templateUrl : 'app/components/views/memberList.html',
        controller : 'FriendController',
        controllerAs : 'friendCtrl',
        requireLogin: true,
        roles: ['USER', 'ADMIN' ]
    },

     //For viewing list of friend request user has received
    "/friendRequest": {
        templateUrl : 'app/components/views/friendRequest.html',
        controller : 'FriendController',
        controllerAs : 'friendCtrl',
        requireLogin: true,
        roles: ['USER', 'ADMIN']
    },
     //For viewing list of friend request user has received
    "/allFriend": {
        templateUrl : 'app/components/views/allfriends.html',
        controller : 'UserController',
        controllerAs : 'userCtrl',
        requireLogin: true,
        roles: ['USER', 'ADMIN']
    },
    "/chat/:id/:username": {
        templateUrl : 'app/components/views/chat.html',
        controller : 'ChatController',
        controllerAs : 'chatCtrl',
        requireLogin: true,
        roles: ['USER','ADMIN']
    },
    //For navigating to error page
    "/error": {
        templateUrl : 'app/components/views/error.html',
        controller : 'RegisterController',
        controllerAs : 'regCtrl',
        requireLogin: false,
        roles: ['GUEST']
    },
    
    "/edit/profile": {
        templateUrl: 'app/components/views/editProfile.html', 
        controller: 'RegisterController', 
        controllerAs: 'regCtrl',
        requireLogin: true,
        roles: ['USER','ADMIN']
    }
};


app.config(['$routeProvider',function($routeProvider){
    for (var path in window.routes){
        $routeProvider.when(path,window.routes[path]);
    }
/* $routeProvider.otherwise({redirectTo:'/login'});*/
}]);
//specify the the backend url from where you are going to get the values
app.constant('REST_URI','http://localhost:8080/Online-Collaborate');

app.run(function($rootScope,$location,RegisterService) {
    $rootScope.logout = function() {
        // call the logout  function created in AuthenticationService
        RegisterService.logout()
        .then(
            // function callback
            function(message) {
                //$rootScope.message = message;
                $location.path('/landingPage');
            }
        );

    };

   
});

 app.directive('fileModel',['$parse',function($parse){
        return {
        restrict: 'A',
        link: function (scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            console.log(model);
            var modelSetter = model.assign;
            element.bind('change', function () {
                scope.$apply(function () {
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
    }]);