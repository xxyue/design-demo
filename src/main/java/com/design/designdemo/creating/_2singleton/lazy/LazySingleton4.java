package com.design.designdemo.creating._2singleton.lazy;

/**
 * @Description: 懒汉式实例
 * @ClassName: LazySingleton
 * @Author: yuexx
 * @Date: 2019/1/25 17:15
 * @Version: 1.0
 */
public class LazySingleton4 {
    private  static  boolean initialized = false;

    //默认使用LazySingleton3 的时候 辉县初始化内部类
    //如果没有使用的话，内部类不加载的
    private LazySingleton4() {
        //防止反射
        synchronized (LazySingleton4.class){
            if (initialized == false){
                initialized = !initialized;
            } else {
                throw  new RuntimeException("单例已被侵犯！");
            }
        }
    }

    public static final LazySingleton4 getInstance() {
        return LazySingleton3Holder.LAZY;
    }

    private static  class LazySingleton3Holder{
        private static final LazySingleton4 LAZY = new LazySingleton4();
    }
}