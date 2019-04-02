package com.design.designdemo.behavior._1strategy;

/**
 * @Description: ${description}
 * @ClassName: PayState
 * @Author: yuexx
 * @Date: 2019/1/30 15:58
 * @Version: 1.0
 */
public class PayState {
    public String code;
    public String msg;
    public String amount;

    public PayState(String code, String msg, String amount) {
        this.code = code;
        this.msg = msg;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "PayState{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
