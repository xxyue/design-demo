package com.design.designdemo.structural._1proxy.dynamic.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description: ${description}
 * @ClassName: MeipoProxy2
 * @Author: yuexx
 * @Date: 2019/1/29 16:52
 * @Version: 1.0
 */
public class MeipoProxy2 implements MethodInterceptor {

    public Object getInstance(Class<?> clazz) throws Exception {
        Enhancer enhancer = new Enhancer();
        //要把哪个类设置成即将生成的父类
        enhancer.setSuperclass(clazz);
        //设置调用类
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //业务增强
        System.out.println("cglib 前做的处理");
        methodProxy.invokeSuper(o,objects);
        System.out.println("cglib 后做的处理");
        return null;
    }
}
