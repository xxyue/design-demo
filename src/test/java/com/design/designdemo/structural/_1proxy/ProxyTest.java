package com.design.designdemo.structural._1proxy;

import com.design.designdemo.structural._1proxy.static_.Father;
import com.design.designdemo.structural._1proxy.static_.Son;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

/**
 * @Description: ${description}
 * @ClassName: FatherTest
 * @Author: yuexx
 * @Date: 2019/1/29 15:44
 * @Version: 1.0
 */
@RunWith(JUnit4.class)
public class ProxyTest {

    @Test
    public void staticProxyTest() {
        Son son = new Son();
        Father father = new Father(son);
        father.findLove();

    }
}