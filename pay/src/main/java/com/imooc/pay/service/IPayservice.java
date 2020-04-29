package com.imooc.pay.service;

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
    PayResponse create(String orderId, BigDecimal amount);

    /**
     * 异步通知
     * @param notifyData
     */
    String asyncNotify(String notifyData);
}
