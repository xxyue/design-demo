package com.design.designdemo.creating._2singleton.lazy;

/**
 * @Description: 懒汉式实例
 * @ClassName: LazySingleton
 * @Author: yuexx
 * @Date: 2019/1/25 17:15
 * @Version: 1.0
 */
public class LazySingleton2 {
    private LazySingleton2(){}
    private static LazySingleton2 lazy = null;

    public static synchronized LazySingleton2 getInstance()  {
        if(lazy == null ){
            //TODO  start 测试代码 非方便验证 非正式代码线程安全性
//            try {
//                Thread.sleep(11L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            //todo end
            lazy = new LazySingleton2();
        }
        return lazy;
    }

}
