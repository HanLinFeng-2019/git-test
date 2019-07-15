package com.pinyougou.page.service;

public interface ItemPageService {
    /**
     * 生成商品详情页
     * @param goodsId
     * @return
     */
    public boolean genItemHtml(Long goodsId);

    /**
     * 删除商品静态页面
     * @param goodsIds
     */
    boolean deleteHtml(Long[] goodsIds);

}
