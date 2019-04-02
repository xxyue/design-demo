package com.design.designdemo.behavior._1strategy.payport;

import com.design.designdemo.behavior._1strategy.PayState;

/**
 * @Description: ${description}
 * @ClassName: AliPay
 * @Author: yuexx
 * @Date: 2019/1/30 16:01
 * @Version: 1.0
 */
public class JDPay implements PayMent {
    @Override
    public PayState pay(String uid, String amount) {
        System.out.println("进入京东 支付");
        System.out.println("查询余额");
        System.out.println("扣款处理！");
        return new PayState("200","扣款成功！",amount);
    }
}
