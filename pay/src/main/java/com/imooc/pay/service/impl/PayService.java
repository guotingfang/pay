package com.imooc.pay.service.impl;

import com.imooc.pay.service.IPayservice;
import com.lly835.bestpay.config.WxPayConfig;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.service.BestPayService;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import com.sun.deploy.panel.IProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Greated by Guo
 *
 * @date2020/4/28 16:13
 */

@Slf4j
@Service
public class PayService implements IPayservice {

    @Autowired
    private BestPayService bestPayService;

    @Override
    public PayResponse create(String orderId, BigDecimal amount) {
        PayRequest request = new PayRequest();
        request.setOrderName("7743843-11sgghffg51");
        request.setOrderId(orderId);
        request.setOrderAmount(amount.doubleValue());
        request.setPayTypeEnum(BestPayTypeEnum.WXPAY_NATIVE);

        PayResponse response = bestPayService.pay(request);
        log.info("response={}",response);
        return response;
    }

    @Override
    public String asyncNotify(String notifyData) {
//        1.签名检验
        PayResponse payResponse = bestPayService.asyncNotify(notifyData);
        log.info("payRespinse={}",payResponse);

//        2.金额校验（从数据库查订单）

//        3.修改订单支付状态

//        4.告诉微信不要在通知了
        return "<xml>\n" +
                "  <return_code><![CDATA[SUCCESS]]></return_code>\n" +
                "  <return_msg><![CDATA[OK]]></return_msg>\n" +
                "</xml>";
    }
}
