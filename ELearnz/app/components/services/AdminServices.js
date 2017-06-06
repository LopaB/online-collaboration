angular.module('CollaborationApp').service('AdminService',function($http,$q,REST_URI){
     // return the user for activation
    this.getUsersForActivation = function() {

        var deferred = $q.defer();

        $http.get(REST_URI + '/admin/user-activation')
        .then(
            function(response) {
                deferred.resolve(response.data);
            },
            function(error){
                deferred.reject(error);
            }
        );
        return deferred.promise;
    }


    // return the text after approving the user
    this.approveUserList = function() {
        var deferred = $q.defer();
        $http.put(REST_URI + '/user/manage/list')
        .then(
            function(response) {
                deferred.resolve(response.data);
            },
            function(error){
                deferred.reject(error);
            }
        );
        return deferred.promise;
    }

    //Function to fetch approved blog list
        this.approvedBlogList=function() {
            var deferred = $q.defer();
            
            $http.get(REST_URI + '/blog/manage/list')
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

         //delete blogs
        this.deleteBlog=function(blogId) {
            var deferred = $q.defer();
            
            $http.post(REST_URI + '/blog/delete/' + blogId)
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

         //delete blogs
        this.updateBlog=function(blog) {
            var deferred = $q.defer();
            
            $http.post(REST_URI + '/blog/update' + blog)
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
});