angular.module('CollaborationApp').service('UploadService',function($q,$http, $rootScope,REST_URI){
    
    // uploadFile function to upload the image on the server
    this.uploadFile = function (file) {

        var deferred = $q.defer();

        // NOTE: the 'Content-Type' is undefined to add a boundary between the multipart content
        // and other data content which is added automatically thats why here we don't use 
                
        var fd = new FormData();
        fd.append('file', file);
        // send the user id which can be used to update the usera
        // and to set the file name
        fd.append('id', $rootScope.user.id);
        $http.post(REST_URI + '/upload/profile-picture', fd, {
            transformRequest: angular.identity,
            headers: { 'Content-Type': undefined }
        })
        .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function (error) {
                console.log(error);
                deferred.reject(error);
            }
        );
        return deferred.promise;
    }

});