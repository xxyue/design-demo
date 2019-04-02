package com.design.designdemo.behavior._1strategy.payport;

/**
 * @Description: ${description}
 * @ClassName: PayType
 * @Author: yuexx
 * @Date: 2019/1/30 16:07
 * @Version: 1.0
 */
public enum PayType {
    ALI_PAY(new AliPay()),
    WECHAT_PAY(new WechatPay()),
    JD_PAY(new JDPay());

    private PayMent payMent;
    private PayType(PayMent payMent){
        this.payMent = payMent;
    }

    public PayMent getPayMent(){
        return payMent;
    }


}
