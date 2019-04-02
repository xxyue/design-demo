package com.design.designdemo.behavior._1strategy.payport;

import com.design.designdemo.behavior._1strategy.PayState;

/**
 * @Description: ${description}
 * @ClassName: PayMent
 * @Author: yuexx
 * @Date: 2019/1/30 15:58
 * @Version: 1.0
 */
public interface PayMent {

    public PayState pay(String uid , String amount);
}
