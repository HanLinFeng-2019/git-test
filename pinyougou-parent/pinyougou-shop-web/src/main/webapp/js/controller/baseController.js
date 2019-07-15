app.controller("baseController",function($scope){
    //重新加载列表 数据
    $scope.reloadList=function(){
        //切换页码
        $scope.search( $scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);

    }
//分页控件配置currentPage:当前页 totalItems:总条数 itemsPerPage:每页记录数 perPageOptions:下拉页码选项 onChange:更改页面时触发的方法
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function(){
            $scope.reloadList();
        }
    }

    $scope.selectIds=[];//用户勾选的ID集合
    //ID勾选绑定
    $scope.updateSelection=function($event,id){
        if($event.target.checked){
            $scope.selectIds.push(id);//向集合中添加元素
        }else{
            var index=$scope.selectIds.indexOf(id);// 查找值的位置
            $scope.selectIds.splice(index,1);//参数1移除的索引,参数2是移除的个数
        }

    }
    //在list中根据某key得值查询对象
    $scope.searchObjectByKey=function(list,key,keyValue){
        for(var i=0;i<list.length;i++){
                if(list[i][key]==keyValue){
                    return list[i];//返回一个goodsDesc表中specificationItems集合的一个对象
                }
        }
        return null;
    }

});