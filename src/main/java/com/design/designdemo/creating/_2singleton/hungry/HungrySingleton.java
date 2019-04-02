package com.design.designdemo.creating._2singleton.hungry;

/**
 * @Description: 恶汉式
 * @ClassName: HungrySingleton
 * @Author: yuexx
 * @Date: 2019/1/25 14:03
 * @Version: 1.0
 */
//他是在类加载的时候就立即初始化了， 并且穿件了单例对象
    // 优点：
    //没有加任何的锁，执行效率比较高
    // 在用户体验上来说，比懒汉式更好

    //缺点：
    //类加载的时候就初始化，不管用不用，都占用空间
    //浪费了内存，  （占着茅坑不拉屎）

    //绝对想成安全的  实例化在线程访问前就已经存在
public class HungrySingleton {

    //不管哪种单例模式第一步都是私有化构造方法
    private HungrySingleton(){
    }

    public static final HungrySingleton hungry = new HungrySingleton();

    public static HungrySingleton getInstance(){
        return hungry;
    }
}
