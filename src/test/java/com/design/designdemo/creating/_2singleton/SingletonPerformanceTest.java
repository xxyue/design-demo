package com.design.designdemo.creating._2singleton;

import com.design.designdemo.creating._2singleton.hungry.HungrySingleton;
import com.design.designdemo.creating._2singleton.lazy.LazySingleton1;
import com.design.designdemo.creating._2singleton.lazy.LazySingleton2;
import com.design.designdemo.creating._2singleton.lazy.LazySingleton2_1;
import com.design.designdemo.creating._2singleton.lazy.LazySingleton3;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @Description: 单例模式的性能测试
 * @ClassName: SingletonTest
 * @Author: yuexx
 * @Date: 2019/1/25 17:22
 * @Version: 1.0
 */
@RunWith(JUnit4.class)
public class SingletonPerformanceTest {

    /**
     * 恶汉试单例模式
     *  10  最后会变成 0
     */
    @Test
    public void hungrySingletonGetInstance() {
        for (int  j = 0; j <10 ; j++) {
            int count = 20000000;
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < count; i++) {
                HungrySingleton hungrySingleton = HungrySingleton.getInstance();
            }
            long endTime = System.currentTimeMillis();
            System.out.println("总耗时：" + (endTime - startTime));
        }
    }


    /**
     * 　懒汉单例模式1
     *  10  最后会变成0
     */
    @Test
    public void LazySingletonGetInstance1() throws InterruptedException {
        for (int  j = 0; j <10 ; j++) {
            int count = 20000000;
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < count; i++) {
                LazySingleton1 lazySingleton1 = LazySingleton1.getInstance();
            }
            long endTime = System.currentTimeMillis();
            System.out.println("总耗时：" + (endTime - startTime));
        }
    }

    /**
     * 　懒汉单例模式2
     *  500
     */
    @Test
    public void LazySingletonGetInstance2() throws InterruptedException {
        for (int  j = 0; j <10 ; j++) {
            int count = 20000000;
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < count; i++) {
                LazySingleton2 lazySingleton2 = LazySingleton2.getInstance();
            }
            long endTime = System.currentTimeMillis();
            System.out.println("总耗时：" + (endTime - startTime));
        }
    }

    /**
     * 　懒汉单例模式2_1 (对锁的优化，只会在并发情况下锁，竞争情况缩小)
     *   15
     */
    @Test
    public void LazySingletonGetInstance2_1() throws InterruptedException {
        for (int  j = 0; j <10 ; j++) {
            int count = 20000000;
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < count; i++) {
                LazySingleton2_1 lazySingleton2 = LazySingleton2_1.getInstance();
            }
            long endTime = System.currentTimeMillis();
            System.out.println("总耗时：" + (endTime - startTime));
        }
    }

    /**
     * 　懒汉单例模式3
     *  10
     */
    @Test
    public void LazySingletonGetInstance3() throws InterruptedException {
        for (int  j = 0; j <10 ; j++) {
            int count = 20000000;
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < count; i++) {
                LazySingleton3 lazySingleton3= LazySingleton3.getInstance();
            }
            long endTime = System.currentTimeMillis();
            System.out.println("总耗时：" + (endTime - startTime));
        }

    }
}