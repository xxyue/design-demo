package com.design.designdemo.structural._1proxy.dynamic.JDK_.theory_0;

import java.lang.reflect.Method;

/**
 * @Description: ${description}
 * @ClassName: MeopoProxy1
 * @Author: yuexx
 * @Date: 2019/1/29 16:11
 * @Version: 1.0
 */
public class MeipoProxy implements MyJDKInvocationHandler {
    private Person person;

    public Object getInstance(Person person) {
        this.person = person;
        Class<?> clazz = person.getClass();
        return MyJDKProxy.newProxyInstance(new MyJDKClassLoader(),clazz.getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       System.out.println("MyJDKInvocationHandler处理前 处理事项~！");
        method.invoke(this.person,args);
       System.out.println("MyJDKInvocationHandler处理后 处理事项");
       return proxy;
    }
}
