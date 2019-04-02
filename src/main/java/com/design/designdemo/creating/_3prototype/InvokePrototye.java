package com.design.designdemo.creating._3prototype;

import org.springframework.beans.BeanUtils;

/**
 * @Description: 利用反射模式
 * @ClassName: InvokePrototye
 * @Author: yuexx
 * @Date: 2019/1/28 16:16
 * @Version: 1.0
 */
public class InvokePrototye {

    //
    public void test(){
        Object obj1 = new CloneTarget();
        Object obj2 = new CloneTarget();
        BeanUtils.copyProperties(obj1,obj2);
    }
}
