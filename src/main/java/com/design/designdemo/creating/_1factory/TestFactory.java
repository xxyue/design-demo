package com.design.designdemo.creating._1factory;

import com.design.designdemo.creating._1factory.abstr.MilkFactory;
import com.design.designdemo.creating._1factory.func.MengniuFactory;
import com.design.designdemo.creating._1factory.func.MilkFuncFactory;
import com.design.designdemo.creating._1factory.simple.MilkSimpleFactory;

/**
 * @Description: 简单工厂模式
 * @ClassName: SimpleFactory
 * @Author: yuexx
 * @Date: 2019/1/24 11:41
 * @Version: 1.0
 */

public class TestFactory {

    //直接new的过程实际上  是一个比较复杂的过程（创建模式任务new的动作 复杂）
    //有人民币 不需要自己new 一个
    public void step1() {
        System.out.println(new Mengniu().getName());
    }

    //简单工厂模式
    //小作坊的生产模式
    //用户本身不在关心生产过程，有需要关心这个结果
    public void step2() {
        //假如 特仑苏、伊利、蒙牛
        //成分配比都不一样
        MilkSimpleFactory factory = new MilkSimpleFactory();
        //把用户的需求高速工厂
        //创建产品的过程隐藏了，而只需要关心这个结果
        Milk milk = factory.getMilk("蒙牛");
        System.out.println(milk.getName());
    }

    //工厂方法模式
    //Spring BeanFactory
    public void step3() {
        //货比三家
        //不知道谁好谁坏
        //配置化  可能配置错误
        //注解
        MilkFuncFactory factory = new MengniuFactory();
        Milk milk = factory.getMilk();
        System.out.println(milk.getName());
    }

    //抽象工厂模式
    public void step4() {
        MilkFactory factory = new MilkFactory();
        //对于用户而言，更加简单
        //用户只有选择权，保障程序的健壮性
        //提供方  和  使用方 解耦
        Milk milk = factory.getMengniu();
        System.out.println(milk.getName());
    }
}
