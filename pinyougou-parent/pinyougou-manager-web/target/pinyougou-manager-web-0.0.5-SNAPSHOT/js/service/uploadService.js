app.service("uploadService",function($http){
    this.uploadFile=function(){

        var formData = new FormData();//HTML5上传数据的工具类
        formData.append("file",file.files[0]);

        //$http.get('url')
        //$http.post('url',data)的另一种书写方式
        return $http({
            //ajax请求方式
            method:'POST',
            url:"../upload.do",
            data:formData,
            headers:{'Content-Type':undefined},
            transformRequest:angular.identity
        });
    }

});