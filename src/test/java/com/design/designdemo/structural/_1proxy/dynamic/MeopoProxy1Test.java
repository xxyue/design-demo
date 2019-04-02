package com.design.designdemo.structural._1proxy.dynamic;

import com.design.designdemo.structural._1proxy.dynamic.JDK_.MeopoProxy1;
import com.design.designdemo.structural._1proxy.dynamic.JDK_.Person;
import com.design.designdemo.structural._1proxy.dynamic.JDK_.Son;
import org.junit.Test;
import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @Description: ${description}
 * @ClassName: MeopoProxy1Test
 * @Author: yuexx
 * @Date: 2019/1/29 16:26
 * @Version: 1.0
 */
public class MeopoProxy1Test {

    @Test
    public void invoke() {
        //原理：
        //1.拿到代理对象的引用，并且在获取到他的所有的接口，  反射获取
        //2.JDK proxy类重新生成一个新的类，同时新的类要实现代理类所有的实现的所有接口
        //3.动态生成java代码--把新增加的业务逻辑
        //4.编译生成的java代码---》生成class
        //5.重新加载到jvm中
        // 以上这个过程就叫字节码重组

        //JDK 中$开头的都是自动生成的
        //内部类， 动态代理

        MeopoProxy1 meopoProxy1 = new MeopoProxy1();
        Son son = new Son();
        System.out.println(son.getClass());
        Person person = (Person) meopoProxy1.getInstance(son);
        System.out.println(person.getClass());
        person.findLove();


        try {
            byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy4",new Class[]{Person.class});
            FileOutputStream os = new FileOutputStream("E://$Proxy4.class");
            os.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}