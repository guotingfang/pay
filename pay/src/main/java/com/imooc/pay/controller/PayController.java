package com.imooc.pay.controller;

import com.imooc.pay.pojo.PayInfo;
import com.imooc.pay.service.IPayservice;
import com.lly835.bestpay.config.WxPayConfig;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Greated by Guo
 *
 * @date2020/4/28 21:36
 */
@Slf4j
@Controller
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private IPayservice payservice;
    @Autowired
    private WxPayConfig wxPayConfig;

    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId") String orderId,
                               @RequestParam("amount") BigDecimal amount,
                               @RequestParam("payTypeEnum") BestPayTypeEnum bestPayTypeEnum
    ){
        PayResponse response = payservice.create(orderId, amount,bestPayTypeEnum);
        Map<String, String> map = new HashMap<>();
//        支付方式不同渲染就不同WXPAY_NATIVE 使用codeUrl ，ALIPAY_PC使用body
            if (bestPayTypeEnum == BestPayTypeEnum.WXPAY_NATIVE){
                map.put("codeUrl", response.getCodeUrl());
                map.put("orderId",orderId);
                map.put("returnUrl",wxPayConfig.getReturnUrl());
            return new ModelAndView("createForWxNative",map);
        }else if (bestPayTypeEnum == BestPayTypeEnum.ALIPAY_PC){
            map.put("body", response.getBody());
            return new ModelAndView("createForAliPayPc",map);
        }
        throw new RuntimeException("暂不支持的支付类型");
    }


    @PostMapping("/notify")
    @ResponseBody
    public String  asyncNotify(@RequestBody String notifyDate){
        return payservice.asyncNotify(notifyDate);
    }

    @GetMapping("/queryByOrderId")
    @ResponseBody
    public PayInfo queryPayInfoByOrderId(@RequestParam("orderId") String orderId){
        return payservice.queryByOrderId(orderId);
    }
}
