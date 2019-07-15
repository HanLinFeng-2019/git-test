package com.pinyougou.pay.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.wxpay.sdk.WXPayUtil;
import com.pinyougou.pay.service.WeixinPayService;
import org.springframework.beans.factory.annotation.Value;
import util.HttpClient;

import java.util.HashMap;
import java.util.Map;
@Service
public class WeixinPayServiceImpl implements WeixinPayService {

    @Value("${appid}")
    private String appid;
    @Value("${partner}")
    private String partner;
    @Value("${partnerkey}")
    private String partnerkey;

    @Override
    public Map createNative(String out_trade_no, String total_fee) {
        //1.????(?????????????)
        Map param=new HashMap();
        param.put("appid",appid);//公众号
        param.put("mch_id",partner);//商户财付通id
        param.put("nonce_str", WXPayUtil.generateNonceStr());//随机字符串
        param.put("body","???");
        param.put("out_trade_no",out_trade_no);//订单号
        param.put("total_fee",total_fee);//总金额
        param.put("spbill_create_ip","127.0.0.1");
        param.put("notify_url","http://www.itcast.cn");//回调地址 不用 ???????????????????? ????????http??
        param.put("trade_type","NATIVE");//交易类型

        try {
            String xmlParam = WXPayUtil.generateSignedXml(param, partnerkey);
            System.out.println("提交给微信的"+xmlParam);

            //2.????
            HttpClient httpClient=new HttpClient("https://api.mch.weixin.qq.com/pay/unifiedorder");
            httpClient.setHttps(true);
            httpClient.setXmlParam(xmlParam);
            httpClient.post();

            //3.????
            String xmlResult = httpClient.getContent();

            Map<String, String> mapResult = WXPayUtil.xmlToMap(xmlResult);
            System.out.println("微信返回的结果"+mapResult);

            Map map=new HashMap<>();
            map.put("code_url",mapResult.get("code_url"));//?????????
            map.put("out_trade_no",out_trade_no);
            map.put("total_fee",total_fee);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return new HashMap();
        }

    }
}
