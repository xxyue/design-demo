package com.design.designdemo.creating._2singleton.seriable;

import java.io.Serializable;

/**
 * @Description: 恶汉式
 * @ClassName: HungrySingleton
 * @Author: yuexx
 * @Date: 2019/1/25 14:03
 * @Version: 1.0
 */
public class SeriableSingleton implements Serializable {

    //不管哪种单例模式第一步都是私有化构造方法
    private SeriableSingleton(){
    }

    public static final SeriableSingleton instance = new SeriableSingleton();

    public static SeriableSingleton getInstance(){
        return instance;
    }

    private Object readResolve(){
        return instance;
    }
}
