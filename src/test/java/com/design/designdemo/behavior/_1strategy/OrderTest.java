package com.design.designdemo.behavior._1strategy;

import com.design.designdemo.behavior._1strategy.payport.PayType;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description: ${description}
 * @ClassName: OrderTest
 * @Author: yuexx
 * @Date: 2019/1/30 16:14
 * @Version: 1.0
 */
public class OrderTest {

    @Test
    public void test() {
        Order order = new Order("823048120384012830","1","20.12");
        PayState payState= order.payState(PayType.JD_PAY);
        System.out.println(payState);
    }
}