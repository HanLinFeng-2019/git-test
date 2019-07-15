app.controller("itemController",function($scope,$http){
   
	$scope.specificationItems={};//存储用户选中的规格
	//数量的加减
	$scope.addNum=function(x){
		$scope.num+=x;
		if($scope.num<1){
			$scope.num=1;
		}
	}
	//用户选择规格 查询整个商品信息
	$scope.selectSpecification=function(key,value){
		$scope.specificationItems[key]=value;
		searchSku();//从页面script标签缓存中查询商品SKU信息
	}
	//规格选中样式
	$scope.isSelected=function(key,value){
		if($scope.specificationItems[key]==value){
			return true;
		}else{
			return false;
		}
	}
	
	//当前选择的SKU
	$scope.sku={};
	
	$scope.loadSku=function(){
		$scope.sku=skuList[0];
		$scope.specificationItems=JSON.parse(JSON.stringify($scope.sku.spec))
	}
	//匹配俩个对象是否相等
	matchObject=function(map1,map2){
		for(var k in map1){
			if(map1[k]!=map2[k]){
				return false;
			}
		}
		for(var k in map2){
			if(map2[k]!=map1[k]){
				return false;
			}
		}
		return true;
	}
	//根据页面规格选项查询SKU
	searchSku=function(){
		for(var i=0;i<skuList.length;i++){
			if(matchObject(skuList[i].spec,$scope.specificationItems)){
				$scope.sku=skuList[i];
				return;
			}
		}
		//如果商品SKU未匹配到,提示前台
		$scope.sku={id:0,title:'商品不存在',price:0}
	}
	//添加SKU到购物车
	$scope.addToCart=function(){
		alert("SKUID:"+$scope.sku.id);
		$http.get('http://localhost:9107/cart/add.do?itemId='+$scope.sku.id+'&num='+$scope.num).success(
			function(response){
				if(response.success){
					location.href='http://localhost:9107/cart.html';
				}else{
					alert(response.message);
				}
			}
		);
	}

});