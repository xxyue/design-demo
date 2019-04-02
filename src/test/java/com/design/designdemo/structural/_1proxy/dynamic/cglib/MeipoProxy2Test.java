package com.design.designdemo.structural._1proxy.dynamic.cglib;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Description: ${description}
 * @ClassName: MeipoProxy2Test
 * @Author: yuexx
 * @Date: 2019/1/29 17:00
 * @Version: 1.0
 */
public class MeipoProxy2Test {

    @Test
    public void getInstance() {
        MeipoProxy2 meipoProxy2 = new MeipoProxy2();
        try {
            Son son = (Son)meipoProxy2.getInstance(Son.class);
            son.findLove();
            System.out.println(son.getClass());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}