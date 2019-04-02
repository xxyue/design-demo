package com.design.designdemo.creating._1factory.func;

import com.design.designdemo.creating._1factory.Milk;

/**
 * @Description: 工厂方法模式
 * @ClassName: funcFactory
 * @Author: yuexx
 * @Date: 2019/1/24 13:50
 * @Version: 1.0
 */
public interface MilkFuncFactory {
    //工厂必然具有生产产品的技能，统一的产品出口
    Milk getMilk();
}
