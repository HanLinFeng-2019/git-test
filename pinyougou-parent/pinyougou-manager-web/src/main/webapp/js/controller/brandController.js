//控制器
app.controller("brandController",function($scope,$controller,brandService){

    //伪继承
    $controller("baseController",{$scope:$scope});

    //查询所有
    $scope.findAll=function(){
        brandService.findAll().success(
            function(response){
                $scope.list=response;
            }
        );
    }


    //分页
    $scope.findPage=function(page,size){
        brandService.findPage(page,size).success(
            function(response){
                $scope.list=response.rows;//显示当前页数据
                $scope.paginationConf.totalItems=response.total;//显示总条数
            }
        );
    }

    //保存
    $scope.save=function(){
        var Object=null;
        if($scope.entity.id!=null){
            Object=brandService.update($scope.entity);
        }else{
            Object=brandService.add($scope.entity);
        }
        Object.success(
            function(response){
                if(response.success){
                    $scope.reloadList();//新增成功,刷新
                }else{
                    alert(response.message)//失败,response释放出失败的message
                }
            }
        );
    }
    //查询实体
    $scope.findOne=function(id){
        brandService.findOne(id).success(
            function(response){
                $scope.entity=response;
            }
        );
    }


    //删除
    $scope.dele=function(){
        brandService.dele($scope.selectIds).success(
            function(response){
                if(response.success){
                    $scope.reloadList();//新增成功,刷新
                }else{
                    alert(response.message)//失败,response释放出失败的message
                }
            }
        );
    }
    $scope.searchEntity={};//初始化
    //条件查询
    $scope.search=function(page,size){
        brandService.search(page,size,$scope.searchEntity).success(
            function(response){
                $scope.list=response.rows;//显示当前页数据
                $scope.paginationConf.totalItems=response.total;//更新总记录数

            }
        );
    }


});