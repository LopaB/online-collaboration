angular.module('CollaborationApp').controller('AdminController', function(AdminService,$rootScope,$scope) {
     var me = this;

    //For temparary storing list of users
    me.tempUserList = [];

    //For list of approved user list
    me.approvedUserList = [];

    //For list of approved blog list
    me.approvedBlogList = [];


    // get all the users for activation
    me.getUsersForActivation = function() {
        AdminService.getUsersForActivation()
        .then(
            function(users) {                
                me.users = users;
            },
            function(error) {
                console.log(error);
            }
        );
    }
 //Function to fetch approved User List
    me.approveUserList = function() {
        //console.log(userId);
        AdminService.approveUserList()
        .then(
            function(approvedUsers  ) {                
                debugger;
                    var index = 0;  //setting up an var index as 0
                    for (var user in approvedUsers) {   //traversing through array to remove user with Super admin role
                        var role = approvedUsers[user].role; 
                        if( role != 'ADMIN') {    //if role is not super admin add the user to new list
                            me.tempUserList[index++] = approvedUsers[user]; 
                        }
                    }
                    me.approvedUserList = me.tempUserList; //assigning temp user list to approvedUserList
            },
            function(error) {
                $rootScope.message = error.message;
            }
        );
    }    

//Function to fetch approved blog List
    me.approvedBlogList = function() {
        
         AdminService.approvedBlogList()
            .then (
                function(approvedBlogs) {
                    me.approvedBlogList = approvedBlogs; 
                    for (var blogPosted in me.approvedBlogList) {   
                        me.approvedBlogList[blogPosted].blogPosted = new Date(me.approvedBlogList[blogPosted].blogPosted[0],me.approvedBlogList[blogPosted].blogPosted[1] - 1,me.approvedBlogList[blogPosted].blogPosted[2]);
                    }
                },
                function(errResponse) {
                }
            );
    }
    
    //update blog
    me.updateBlog = function(blog) {
        
        AdminService.updateBlog(blog)
            .then (
                function(blog) {
                    $route.reload();
                },
                function(errResponse) {
                }
            );
    }
    //update blog
    me.deleteBlog = function(blogId) {
        
        AdminService.deleteBlog(blogId)
            .then (
                function(blog) {
                    $route.reload();
                },
                function(errResponse) {
                }
            );
    }


});