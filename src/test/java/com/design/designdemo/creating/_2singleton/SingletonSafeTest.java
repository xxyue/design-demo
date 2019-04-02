package com.design.designdemo.creating._2singleton;

import com.design.designdemo.creating._2singleton.lazy.LazySingleton1;
import com.design.designdemo.creating._2singleton.lazy.LazySingleton2;
import com.design.designdemo.creating._2singleton.lazy.LazySingleton3;
import com.design.designdemo.creating._2singleton.lazy.LazySingleton4;
import com.design.designdemo.creating._2singleton.register.RegisterConcMap;
import com.design.designdemo.creating._2singleton.register.RegisterEnum;
import com.design.designdemo.creating._2singleton.register.RegisterMap;
import com.design.designdemo.creating._2singleton.hungry.HungrySingleton;
import com.design.designdemo.creating._2singleton.seriable.SeriableSingleton;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.concurrent.CountDownLatch;

/**
 * @Description: 单例模式的线程安全测试
 * @ClassName: SingletonTest
 * @Author: yuexx
 * @Date: 2019/1/25 17:22
 * @Version: 1.0
 */
@RunWith(JUnit4.class)
public class SingletonSafeTest {

    /**
     * 恶汉试单例模式
     * <p>
     * 测试线程线程安全问题
     * 对象的引用没有变化
     * 所以实现城安全的
     * <p>
     * 缺点：不管用不用类加载时，就先new出来了
     */
    @Test
    public void hungrySingletonGetInstance() {
        int count = 100;
        for (int i = 0; i < count; i++) {
            new Thread() {
                @Override
                public void run() {
                    HungrySingleton hungrySingleton = HungrySingleton.getInstance();
                    System.out.println(System.currentTimeMillis());
                    System.out.println(hungrySingleton);
                }
            }.start();
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * 　懒汉单例模式1
     * <p>
     * 测试线程线程安全问题
     * 1写法懒汉线程不安全
     */
    @Test
    public void LazySingletonGetInstance1() {
        int count = 100;
        for (int i = 0; i < count; i++) {
            new Thread() {
                @Override
                public void run() {
                    LazySingleton1 lazySingleton1 = LazySingleton1.getInstance();
                    System.out.println(lazySingleton1);
                }
            }.start();
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 　懒汉单例模式2
     * <p>
     * 测试线程线程安全问题
     * 2写法懒汉线程安全
     */
    @Test
    public void LazySingletonGetInstance2() {
        int count = 100;
        for (int i = 0; i < count; i++) {
            new Thread() {
                @Override
                public void run() {
                    LazySingleton2 lazySingleton1 = LazySingleton2.getInstance();
                    System.out.println(lazySingleton1);
                }
            }.start();
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 　懒汉单例模式3
     * <p>
     * 测试线程线程安全问题
     * 2写法懒汉线程安全
     */
    @Test
    public void LazySingletonGetInstance3() {
        int count = 100;
        for (int i = 0; i < count; i++) {
            new Thread() {
                @Override
                public void run() {
                    LazySingleton3 lazySingleton3 = LazySingleton3.getInstance();
                    System.out.println(lazySingleton3);
                }
            }.start();
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 　懒汉单例模式4
     * <p>
     * 可以反射使用, 这样就可以生成多个对象了
     */
    @Test
    public void LazySingletonNewInstance3() {
        //第一次调用构造方法
        LazySingleton3 lazySingleton3 = LazySingleton3.getInstance();
        System.out.println(lazySingleton3);
        try {
            Class<?> clazz = LazySingleton3.class;
            Constructor<?> c = clazz.getDeclaredConstructor(null);
            c.setAccessible(true);
            //第二次调用构造方法
            Object ob = c.newInstance();
            System.out.println(ob);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 　懒汉单例模式4
     * <p>
     * 不可以反射使用
     */
    @Test
    public void LazySingletonNewInstance4() {
        //第一次调用构造方法
        LazySingleton4 lazySingleton4 = LazySingleton4.getInstance();
        System.out.println(lazySingleton4);
        try {
            Class<?> clazz = LazySingleton4.class;
            Constructor<?> c = clazz.getDeclaredConstructor(null);
            c.setAccessible(true);
            //第二次调用构造方法
            Object ob = c.newInstance();
            System.out.println(ob);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 　懒汉单例模式4
     * <p>
     * 不可以反射使用,但可以用反射修改变量
     */
    @Test
    public void LazySingletonNewInstanceChange4() {
        //第一次调用构造方法
        LazySingleton4 lazySingleton4 = LazySingleton4.getInstance();
        System.out.println(lazySingleton4);
        try {

            Class<?> clazz = LazySingleton4.class;
            Constructor<?> c = clazz.getDeclaredConstructor(null);
            c.setAccessible(true);
            //TODO
            Field field = clazz.getDeclaredField("initialized");
            field.setAccessible(true);
            field.set(clazz, false);
            System.out.println(field);
            //第二次调用构造方法
            Object ob = c.newInstance();
            System.out.println(ob);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * map  注册形式的单例
     */
    @Test
    public void RegisterMap() {
        RegisterMap.getInstance(null);
    }

    /**
     * 枚举 注册形式的单例
     */
    @Test
    public void RegisterEnum() {
        RegisterEnum instance = RegisterEnum.INSTANCE;
    }

    /**
     * 序列化单例
     */
    @Test
    public void SeriableSingleton() {
        SeriableSingleton s1 = null;
        SeriableSingleton s2 = SeriableSingleton.getInstance();
        try {
            FileOutputStream fos = new FileOutputStream("seriable.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s2);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("seriable.obj");
            ObjectInputStream ois =  new ObjectInputStream(fis);
            s1 = (SeriableSingleton)ois.readObject();
            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s1 == s2);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        }

    }


    /**
     * 　懒汉单例模式1
     * <p>
     * 测试线程线程安全问题
     * 1写法懒汉线程安全  这种写法多线程，但是 随机性大
     */
    @Test
    public void LazySingletonGetInstance20() {
        int count = 30;
        CountDownLatch latch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        latch.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    LazySingleton1 lazySingleton1 = LazySingleton1.getInstance();
                    System.out.println(lazySingleton1);
                }
            }.start();
            latch.countDown();
        }
    }

    /**
     * 　map注册单例模式1
     * <p>
     * 测试线程线程安全问题
     * 1写法懒汉线程安全  这种写法多线程，但是 随机性大
     */
    @Test
    public void registerConcMap() {
        int count = 300;
        CountDownLatch latch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        latch.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    Object register = RegisterConcMap.getBean("com.design.designdemo.creating._2singleton.register.RegisterConcMap");
                    System.out.println(register);
                }
            }.start();
            latch.countDown();
        }

    }
}