package com.design.designdemo.structural._1proxy.dynamic.JDK_;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description: ${description}
 * @ClassName: MeopoProxy1
 * @Author: yuexx
 * @Date: 2019/1/29 16:11
 * @Version: 1.0
 */
public class MeopoProxy1 implements InvocationHandler {
    private Person person;

    public Object getInstance(Person person) {
        this.person = person;
        Class<?> clazz = person.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       System.out.println("处理前 处理事项~！");
        method.invoke(this.person,args);
       System.out.println("处理后 处理事项");
       return proxy;
    }
}
