package com.design.designdemo.creating._2singleton.lazy;

/**
 * @Description: 懒汉式实例
 * @ClassName: LazySingleton
 * @Author: yuexx
 * @Date: 2019/1/25 17:15
 * @Version: 1.0
 */
public class LazySingleton2_1 {
    private LazySingleton2_1(){}
    private static LazySingleton2_1 lazy = null;

    public static  LazySingleton2_1 getInstance()  {
        if(lazy == null ){
            //TODO  start 测试代码 非方便验证 非正式代码线程安全性
//            try {
//                Thread.sleep(11L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            //todo end
            synchronized(LazySingleton2_1.class){
                if(lazy == null ){
                    lazy = new LazySingleton2_1();
                }
            }
        }
        return lazy;
    }

}
