package com.imooc.pay.service.impl;

import com.imooc.pay.PayApplication;
import com.imooc.pay.PayApplicationTests;
import com.imooc.pay.service.IPayservice;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class PayServiceTest extends PayApplicationTests {

    @Autowired
    private IPayservice payservice;
    @Test
    public void create() {

        payservice.create("1234568790", BigDecimal.valueOf(0.01));
    }
}