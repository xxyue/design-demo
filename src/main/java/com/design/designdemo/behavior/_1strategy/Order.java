package com.design.designdemo.behavior._1strategy;

import com.design.designdemo.behavior._1strategy.payport.PayType;

/**
 * @Description: ${description}
 * @ClassName: Order
 * @Author: yuexx
 * @Date: 2019/1/30 16:00
 * @Version: 1.0
 */
public class Order {
    public String orderId;
    public String uid;
    public String aount;

    public Order(String orderId, String uid, String aount) {
        this.orderId = orderId;
        this.uid = uid;
        this.aount = aount;
    }

    public PayState payState(PayType payType){
        return payType.getPayMent().pay(this.uid,this.aount);
    }
}
