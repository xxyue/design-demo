package com.design.designdemo.structural._1proxy.dynamic.JDK_.theory_0;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


/**
 * @Description: ${description}
 * @ClassName: MyJDKProxyTest
 * @Author: yuexx
 * @Date: 2019/1/30 10:31
 * @Version: 1.0
 */
@RunWith(JUnit4.class)
public class MyJDKProxyTest {

    @Test
    public void newProxyInstance() {
        MeipoProxy meopoProxy1 = new MeipoProxy();
        Son son = new Son();
        System.out.println(son.getClass());
        Person person = (Person) meopoProxy1.getInstance(son);
//        System.out.println(person.getClass());
//        person.findLove();
    }
}