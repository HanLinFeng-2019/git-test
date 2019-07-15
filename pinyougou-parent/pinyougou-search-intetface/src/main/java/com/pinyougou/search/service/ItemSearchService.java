package com.pinyougou.search.service;

import java.util.List;
import java.util.Map;

public interface ItemSearchService {
    /**
     * 条件查询
     * @param searchMap
     * @return
     */
    public Map search(Map searchMap);

    public Map searchBrandAndSpecList(String category);

    /**
     * 导入SKU列表
     * @param list
     */
    public void importList(List list);

    /**
     * 删除商品 同时删除solr索引库Id
     * @param goodsIdList
     */
    public void deleteByGoodsId(List goodsIdList);
}
