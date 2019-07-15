app.controller("indexController",function($scope,loginService){


    //显示登陆用户名称
    $scope.showName=function(){
        loginService.loginName().success(
            function(response){
                $scope.loginName=response.loginName;
            }
        );
    }

});