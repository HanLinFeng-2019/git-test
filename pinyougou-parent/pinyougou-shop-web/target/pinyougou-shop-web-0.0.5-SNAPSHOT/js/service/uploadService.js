app.service('uploadService',function($http){

    this.uploadFile=function(){

        var formdata = new FormData();//HTML5上传数据的工具类
        formdata.append('file',file.files[0]);

        //$http.get('url')
        //$http.post('url',data)的另一种书写方式
        return $http({
            //ajax请求方式
            method:'post',
            url:"../upload.do",
            data:formdata,
            headers:{'Content-Type':undefined},
            transformRequest:angular.identity
        });
    }

});