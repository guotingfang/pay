package com.imooc.pay.service.impl;

import com.imooc.pay.PayApplication;
import com.imooc.pay.PayApplicationTests;
import com.imooc.pay.service.IPayservice;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class PayServiceTest extends PayApplicationTests {

    @Autowired
    private IPayservice payservice;
    @Test
    public void create() {

        payservice.create("123456871111190", BigDecimal.valueOf(0.01), BestPayTypeEnum.WXPAY_NATIVE);
    }
}