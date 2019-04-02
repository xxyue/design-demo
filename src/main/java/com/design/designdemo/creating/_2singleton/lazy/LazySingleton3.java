package com.design.designdemo.creating._2singleton.lazy;

/**
 * @Description: 懒汉式实例
 * @ClassName: LazySingleton
 * @Author: yuexx
 * @Date: 2019/1/25 17:15
 * @Version: 1.0
 */
public class LazySingleton3 {

    //默认使用LazySingleton3 的时候 会先初始化内部类
    //如果没有使用的话，内部类不加载的
    private LazySingleton3() {
    }

    public static final LazySingleton3 getInstance() {
        return LazySingleton3Holder.LAZY;
    }

    private static  class LazySingleton3Holder{
        private static final LazySingleton3 LAZY = new LazySingleton3();
    }
}