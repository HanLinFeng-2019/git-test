package com.pinyougou.page.service.impl;


import com.pinyougou.mapper.TbGoodsDescMapper;
import com.pinyougou.mapper.TbGoodsMapper;
import com.pinyougou.mapper.TbItemCatMapper;
import com.pinyougou.mapper.TbItemMapper;
import com.pinyougou.page.service.ItemPageService;
import com.pinyougou.pojo.TbGoods;
import com.pinyougou.pojo.TbGoodsDesc;
import com.pinyougou.pojo.TbItem;
import com.pinyougou.pojo.TbItemExample;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemPageServiceImpl implements ItemPageService{

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;
    @Value("${pagedir}")
    private String pagedir;
    @Autowired
    private TbGoodsMapper goodsMapper;
    @Autowired
    private TbGoodsDescMapper goodsDescMapper;
    @Autowired
    private TbItemCatMapper itemCatMapper;
    @Autowired
    private TbItemMapper itemMapper;

    @Override
    public boolean genItemHtml(Long goodsId) {
        //1.创建配置对象
        Configuration configuration = freeMarkerConfigurer.getConfiguration();
        //2.加载模板对象
        try {
            Template template = configuration.getTemplate("item.ftl");
            //3.获取数据模型
            Map dataModel=new HashMap();

            //3.1商品主表信息
            TbGoods goods = goodsMapper.selectByPrimaryKey(goodsId);
            dataModel.put("goods",goods);

            //3.2商品扩展表信息
            TbGoodsDesc goodsDesc = goodsDescMapper.selectByPrimaryKey(goodsId);
            dataModel.put("goodsDesc",goodsDesc);

            //3.3商品分类信息
            String itemCat1 = itemCatMapper.selectByPrimaryKey(goods.getCategory1Id()).getName();
            String itemCat2 = itemCatMapper.selectByPrimaryKey(goods.getCategory2Id()).getName();
            String itemCat3 = itemCatMapper.selectByPrimaryKey(goods.getCategory3Id()).getName();
            dataModel.put("itemCat1",itemCat1);
            dataModel.put("itemCat2",itemCat2);
            dataModel.put("itemCat3",itemCat3);

            //3.4读取SKU列表
            TbItemExample example=new TbItemExample();
            TbItemExample.Criteria criteria = example.createCriteria();
            criteria.andGoodsIdEqualTo(goodsId);//SPU ID
            criteria.andStatusEqualTo("1");//审核通过
            example.setOrderByClause("is_default desc");//按是否默认字段进行降序排序,目的时返回的结果第一条是默认SKU

            List<TbItem> itemList = itemMapper.selectByExample(example);
            dataModel.put("itemList",itemList);
            //4.输出流
            Writer out=new FileWriter(pagedir+goodsId+".html");
            //5.输出
            template.process(dataModel,out);
            //6.关闭
            out.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteHtml(Long[] goodsIds) {
        try {
            for (Long goodsId : goodsIds) {
                new File(pagedir+goodsId+".html").delete();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
