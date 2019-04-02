package com.design.designdemo.creating._1factory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @Description: ${description}
 * @ClassName: TestFactoryTest
 * @Author: yuexx
 * @Date: 2019/1/24 13:52
 * @Version: 1.0
 */
@RunWith(JUnit4.class)
public class TestFactoryTest {
    TestFactory simpleFactory = new TestFactory();

    @Test
    public void step1() {
        simpleFactory.step1();
    }

    @Test
    public void step2() {
        simpleFactory.step2();;
    }

    @Test
    public void step3() {
        simpleFactory.step3();
    }

    @Test
    public void step4() {
        simpleFactory.step4();
    }
}