app.controller("searchController",function($scope,$location,searchService){

    $scope.searchMap={'keywords':'','category':'','brand':'','spec':{},'price':'','pageNo':1,'pageSize':40,'sort':'','sortField':''};

    //搜索
    $scope.search=function(){
        $scope.searchMap.pageNo=parseInt($scope.searchMap.pageNo);
        searchService.search($scope.searchMap).success(
            function(response){
                $scope.resultMap=response;
               buildPageLabel();//调用分页
            }
        );
    }
    //构建分页标签
    buildPageLabel=function(){
        $scope.pageLabel=[];
        var firstPage=1;//开始页码
        var lastPage=$scope.resultMap.totalPages;//截止页码

        if($scope.resultMap.totalPages>5){
            if($scope.searchMap.pageNo<=3){//显示前5页
                lastPage=5;
            }else if($scope.searchMap.pageNo>=lastPage-2){//显示后5页
                firstPage=lastPage-4;
            }else{//显示当前页为中心的5页
                firstPage=$scope.searchMap.pageNo-2;
                lastPage=$scope.searchMap.pageNo+2;
            }
        }
        //构建页码
        for(var i=firstPage;i<=lastPage;i++) {
            $scope.pageLabel.push(i);
        }
    }

    //添加搜索项
    $scope.addSearchItem=function(key,value){
        if(key=='category' || key=='brand'|| key=='price'){
            $scope.searchMap[key]=value;
        }else{
            $scope.searchMap.spec[key]=value;
        }
        $scope.search();//执行搜索
    }

    //移除复合搜索选项(搜索面包屑)
    $scope.removeSearchItem=function(key){
        if(key=='category'|| key=='brand'|| key=='price'){//如果是分类或者品牌
            $scope.searchMap[key]="";
        }else{//或者是规格
            delete $scope.searchMap.spec[key];//移除此属性
        }
        $scope.search();//执行搜索
    }
    //分页查询
    $scope.queryByPage=function(pageNo){
        if(pageNo<1||pageNo>$scope.resultMap.totalPages){
            return;
        }
        $scope.searchMap.pageNo=pageNo;
        $scope.search();//按页码查询
    }
    //判断当前页是否为第一页
    $scope.isTopPage=function(){
        if($scope.searchMap.pageNo==1){
            return true;
        }else{
            return false;
        }
    }
    //判断当前页是否为最后一页
    $scope.isEndPage=function(){
        if($scope.searchMap.pageNo==$scope.resultMap.totalPages){
            return true;
        }else{
            return false;
        }
    }
    //排序查询
    $scope.sortSearch=function(sortField,sort){
        $scope.searchMap.sortField=sortField;
        $scope.searchMap.sort=sort;
        $scope.search();
    }
    //判断品牌是否是关键字
    $scope.keywordsIsBrand=function(){
        for(var i=0;i<$scope.resultMap.brandList.length;i++){
            if($scope.searchMap.keywords.indexOf($scope.resultMap.brandList[i].text)>=0){
                return true;
            }
        }
        return false;
    }
    //关联主页搜索
    $scope.loadkeywords=function(){
        $scope.searchMap.keywords=$location.search()['keywords'];
        $scope.search();//搜索
    }
});