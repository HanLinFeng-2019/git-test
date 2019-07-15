 //控制层 
app.controller('goodsController' ,function($scope,$controller ,$location,itemCatService,goodsService){
	
	$controller('baseController',{$scope:$scope});//继承
	
    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
		goodsService.findAll().success(
			function(response){
				$scope.list=response;
			}			
		);
	}    
	
	//分页
	$scope.findPage=function(page,rows){			
		goodsService.findPage(page,rows).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}

    //商品添加的实体类的元素组成
    // $scope.entity={goods:{},goodsDesc:{itemImages:[],specificationItems:[],customAttributeItem:[]}};
    $scope.entity={ goodsDesc:{itemImages:[],specificationItems:[]}  };

//查询实体
    $scope.findOne=function(){
        var id=$location.search()['id'];//获取参数值
        if(id==null){
            return;
        }
        goodsService.findOne(id).success(
            function(response){
                $scope.entity= response;
                //富文本显示的数据获取
                editor.html($scope.entity.goodsDesc.introduction);
                //图片显示的数据获取
                $scope.entity.goodsDesc.itemImages=JSON.parse($scope.entity.goodsDesc.itemImages);
                //扩展属性显示的数据获取
                $scope.entity.goodsDesc.customAttributeItems=JSON.parse($scope.entity.goodsDesc.customAttributeItems);
                //规格属性显示的数据获取
                $scope.entity.goodsDesc.specificationItems=JSON.parse($scope.entity.goodsDesc.specificationItems);
                //显示规格
                for(var i=0;i<$scope.entity.itemList.length;i++){
                    $scope.entity.itemList[i].spec=JSON.parse($scope.entity.itemList[i].spec);
                }
            }
        );
    }
	
	//保存 
	$scope.save=function(){				
		var serviceObject;//服务层对象  				
		if($scope.entity.id!=null){//如果有ID
			serviceObject=goodsService.update( $scope.entity ); //修改  
		}else{
			serviceObject=goodsService.add( $scope.entity  );//增加 
		}				
		serviceObject.success(
			function(response){
				if(response.success){
					//重新查询 
		        	$scope.reloadList();//重新加载
				}else{
					alert(response.message);
				}
			}		
		);				
	}
	
	 
	//批量删除 
	$scope.dele=function(){			
		//获取选中的复选框			
		goodsService.dele( $scope.selectIds ).success(
			function(response){
				if(response.success){
					$scope.reloadList();//刷新列表
					$scope.selectIds=[];
				}						
			}		
		);				
	}
	
	$scope.searchEntity={};//定义搜索对象 
	
	//搜索
	$scope.search=function(page,rows){			
		goodsService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}

    //状态修改
    $scope.status=['未审核','已审核','审核未通过','已关闭'];

    $scope.itemCatList=[];
    $scope.findItemCatList=function(){
        itemCatService.findAll().success(
            function(response){
                for(var i=0;i<response.length;i++){
                    $scope.itemCatList[response[i].id]=response[i].name;
                }
            }
        );
    }

    //显示一级下拉列表
    $scope.selectItmeCat1List=function(){
        itemCatService.findByParentId(0).success(
            function(response){
                $scope.itemCat1List=response;
            }
        );
    }
    //显示二级下拉列表
    $scope.$watch('entity.goods.category1Id',function(newvalue,oldvalue){
        itemCatService.findByParentId(newvalue).success(
            function(response){
                $scope.itemCat2List=response;
            }
        );
    });
    //显示三级下拉列表
    $scope.$watch('entity.goods.category2Id',function(newvalue,oldvalue){
        itemCatService.findByParentId(newvalue).success(
            function(response){
                $scope.itemCat3List=response;
            }
        );
    });
	//修改商品审核状态
    $scope.updateStatus=function(status){
    	goodsService.updateStatus($scope.selectIds,status).success(
    		function(response){
    			if(response.success){
    				alert(response.message);
    				$scope.selectIds=[];
					$scope.reloadList();
				}else{
    				alert(response.message);
				}
			}
		);
    }

    
});	
