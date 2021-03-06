package com.imooc.pay.service;

import com.imooc.pay.pojo.PayInfo;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayResponse;

import java.math.BigDecimal;

/**
 * Greated by Guo
 *
 * @date2020/4/28 16:11
 */

public interface IPayservice {

    /**
     * 创建/发起支付
     */
    PayResponse create(String orderId, BigDecimal amount, BestPayTypeEnum bestPayTypeEnum);

    /**
     * 异步通知
     * @param notifyData
     */
    String asyncNotify(String notifyData);

    /**
     * 查询支付记录（通过订单号）
     * @param orderId
     * @return
     */
    PayInfo queryByOrderId(String orderId);
}
