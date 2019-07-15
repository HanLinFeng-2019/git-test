package com.pinyougou.pay.service;

import java.util.Map;

/**
 * 微信支付模块接口
 */
public interface WeixinPayService {
    /**
     * 生成二维码 (交易类型为Native)
     * @param out_trade_no 商户系统提供的订单号
     * @param total_fee 总金额
     * @return
     */
    public Map createNative(String out_trade_no,String total_fee);
}
