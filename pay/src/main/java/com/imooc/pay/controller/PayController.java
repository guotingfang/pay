package com.imooc.pay.controller;

import com.imooc.pay.service.IPayservice;
import com.lly835.bestpay.model.PayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

@Controller
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private IPayservice payservice;

    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId") String orderId,
                               @RequestParam("amount") BigDecimal amount
    ){
        PayResponse response = payservice.create("1234568790", BigDecimal.valueOf(0.01));
        Map map = new HashMap();
        map.put("codeUrl", response.getCodeUrl());
        return new ModelAndView("create",map);
    }
}
