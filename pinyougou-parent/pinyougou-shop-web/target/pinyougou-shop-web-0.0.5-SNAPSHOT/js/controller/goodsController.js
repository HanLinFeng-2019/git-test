 //控制层 
app.controller('goodsController' ,function($scope,$controller,$location ,goodsService,uploadService,itemCatService,typeTemplateService){
	
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
		$scope.entity.goodsDesc.introduction=editor.html();
		var serviceObject;//服务层对象  				
		if($scope.entity.goods.id!=null){//如果有ID
			serviceObject=goodsService.update( $scope.entity ); //修改  
		}else{
            $scope.entity.goodsDesc.introduction=editor.html();//将富文本编辑的内容绑定给商品描述
			serviceObject=goodsService.add( $scope.entity  );//增加
		}				
		serviceObject.success(
			function(response){
				if(response.success){
					//重新查询 
		        	alert("添加成功");
		        	$scope.entity={};
		        	editor.html('');//清空富文本编辑器内容
					location.href='goods.html';
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
	//上传图片
	$scope.uploadFile=function(){
		uploadService.uploadFile().success(
			function(response){
				if(response.success){
					$scope.image_entity.url=response.message;
				}else{
					alert(response.message);
				}
			}
		).error(function(){
			alert("上传发生错误");
			});
	}
	//商品添加的实体类的元素组成
	// $scope.entity={goods:{},goodsDesc:{itemImages:[],specificationItems:[],customAttributeItem:[]}};
    $scope.entity={ goodsDesc:{itemImages:[],specificationItems:[]}  };
	//添加图片
	$scope.save_image=function(){
		$scope.entity.goodsDesc.itemImages.push($scope.image_entity);
	}
	//集合中删除图片
	$scope.remove_image=function(index){
		$scope.entity.goodsDesc.itemImages.splice(index,1);
	}
	//商品新增下拉列表
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
    //显示模板ID
    $scope.$watch('entity.goods.category3Id',function(newvalue,oldvalue){
        itemCatService.findOne(newvalue).success(
            function(response){
                $scope.itemCat4=response;
            }
        );
    });
    //显示品牌列表和扩展属性
    $scope.$watch('itemCat4.typeId',function(newvalue,oldvalue){
        typeTemplateService.findOne(newvalue).success(
            function(response){
                $scope.typeTemplate=response;
                $scope.typeTemplate.brandIds=JSON.parse($scope.typeTemplate.brandIds);
                if($location.search()['id']==null){
                    $scope.entity.goodsDesc.customAttributeItems=JSON.parse($scope.typeTemplate.customAttributeItems);
				}

            }
        );
    });
    //显示规格列表
    $scope.$watch('itemCat4.typeId',function(newvalue,oldvalue){
        typeTemplateService.findSpecOptionList(newvalue).success(
            function(response){
                $scope.SpecOptionList=response;
            }
        );
    });
    //$scope.entity={goods:{},goodsDesc:{itemImages:[],specification:[]}};
	//规格选项组合的显示
    $scope.updateSpecAttribute=function($event,name,value){
    	//object是goodsDesc.specificationItems集合中的一个对象
    	var object = $scope.searchObjectByKey($scope.entity.goodsDesc.specificationItems,'attributeName',name);
    	if(object!=null){
    		if($event.target.checked){//勾选中目标
                object.attributeValue.push(value);
			}else{//勾选取消
    			object.attributeValue.splice(object.attributeValue.indexOf(value),1);
			}
			if(object.attributeValue.length==0){//当前object对象中的value勾选全部取消,则删除当前object对象
                $scope.entity.goodsDesc.specificationItems.splice($scope.entity.goodsDesc.specificationItems.indexOf(object),1);
			}
		}else{
    		$scope.entity.goodsDesc.specificationItems.push({"attributeName":name,"attributeValue":[value]});
		}
	}

	//规格排列组合显示
	$scope.createItemList=function(){
    	$scope.entity.itemList=[{spec:{},price:0,num:9999,status:'0',isDefault:'0'}];//初始化数据类型
		var items=$scope.entity.goodsDesc.specificationItems;
		for(var i=0;i<items.length;i++){
			$scope.entity.itemList=addColumn($scope.entity.itemList,items[i].attributeName,items[i].attributeValue);
		}
	}

	addColumn=function(list,columnName,columnValues){
    	var newList=[];
    	for(var i=0;i<list.length;i++){
    		var oldRow=list[i];
    		for(var j=0;j<columnValues.length;j++){
    			var newRow=JSON.parse(JSON.stringify(oldRow));//深克隆,克隆其内容

    			newRow.spec[columnName]=columnValues[j];//将
    			newList.push(newRow);
			}
		}
		return newList;
	}
	//状态修改
	$scope.status=['未审核','已审核','审核未通过','已关闭'];

    $scope.itemCatList=[];
    $scope.findItemCat=function(){
    	itemCatService.findAll().success(
				function(response){
					for(var i=0;i<response.length;i++){
						$scope.itemCatList[response[i].id]=response[i].name;
					}
				}
		);
	}

	//判断规格是否被勾选
	$scope.checkAttributeValue=function(specName,optionName){
        var items=$scope.entity.goodsDesc.specificationItems;
        var object =$scope.searchObjectByKey(items,'attributeName',specName);
        if(object=!null){
        	if(object.attributeValue.indexOf(optionName)>=0){
				return true;
			}else{
        		return false;
			}
		}else{
        	return false;
		}
	}

    
});	
