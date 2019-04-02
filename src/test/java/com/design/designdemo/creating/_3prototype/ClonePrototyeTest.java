package com.design.designdemo.creating._3prototype;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @Description: 克隆
 * @ClassName: ClonePrototyeTest
 * @Author: yuexx
 * @Date: 2019/1/28 14:53
 * @Version: 1.0
 */
public class ClonePrototyeTest {

    /**
     * 浅拷贝 只是本对象的地址一个新的，但是属性直接地址直接复制过来
     */
    @Test
    public void clonePrototye1() {
        ClonePrototye1 p = new ClonePrototye1();
        p.name = "yuexx";
        p.list = new ArrayList();
        p.list.add(new CloneTarget());
        p.target = new CloneTarget();
        System.out.println("ClonePrototye1对象地址 ： " + p);
        System.out.println("ClonePrototye1.List 对象地址 ： " + p.list);
        System.out.println("时间： " + p.target.birthday.getTime());
        try {
            ClonePrototye1 obj = (ClonePrototye1) p.clone();
            System.out.println("克隆对象地址 ： " + obj);
            System.out.println("克隆对象List 地址 ： " + obj.list);
            System.out.println(obj.name);
            System.out.println("时间： " + obj.target.birthday.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 深度拷贝 多有属性都是新的地址，利用序列话全部生成新对象(其中的值都是相等的)
     */
    @Test
    public void clonePrototye2() {
        ClonePrototye2 p = new ClonePrototye2();
        p.name = "yuexx";
        p.list = new ArrayList();
        p.list.add(new CloneTarget());
        p.target = new CloneTarget();
        System.out.println("ClonePrototye1对象地址 ： " + p);
        System.out.println("ClonePrototye1.List 对象地址 ： " + p.list);
        System.out.println("ClonePrototye1.List 对象第一个元素地址 ： " + p.list.get(0));
        System.out.println("时间： " + p.target.birthday.getTime());
        try {
            ClonePrototye2 obj = (ClonePrototye2) p.clone();
            System.out.println(obj.name);
            System.out.println("克隆对象地址 ： " + obj);
            System.out.println("克隆对象List 地址 ： " + obj.list);
            System.out.println("ClonePrototye1.List 对象第一个元素地址 ： " + obj.list.get(0));
            System.out.println("时间： " + obj.target.birthday.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}