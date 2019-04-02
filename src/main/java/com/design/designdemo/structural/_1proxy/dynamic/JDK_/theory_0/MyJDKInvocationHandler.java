package com.design.designdemo.structural._1proxy.dynamic.JDK_.theory_0;

import java.lang.reflect.Method;

/**
 * @Description:  JDK 代理模拟
 * @ClassName: MyJDKInvocationHandler
 * @Author: yuexx
 * @Date: 2019/1/29 17:31
 * @Version: 1.0
 */
public interface MyJDKInvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
