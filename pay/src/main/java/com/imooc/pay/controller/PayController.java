package com.imooc.pay.controller;

import com.imooc.pay.service.IPayservice;
import com.lly835.bestpay.model.PayResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.ws.spi.WebServiceFeatureAnnotation;
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

    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId") String orderId,
                               @RequestParam("amount") BigDecimal amount
    ){
        PayResponse response = payservice.create(orderId, amount);
        Map map = new HashMap();
        map.put("codeUrl", response.getCodeUrl());
        return new ModelAndView("create",map);
    }


    @PostMapping("/notify")
    @ResponseBody
    public String  asyncNotify(@RequestBody String notifyDate){
        return payservice.asyncNotify(notifyDate);
    }
}
