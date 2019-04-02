package com.design.designdemo.structural._3decorator;

import java.io.DataInputStream;
import java.io.FilterInputStream;
import java.io.InputStream;

/**
 * @Description: 装饰器模式
 * @ClassName: Test
 * @Author: yuexx
 * @Date: 2019/2/13 14:43
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {

        //为了魔种实现类在不修改原始类的基础上进行动态的覆盖或者增加方法
        //改实现保持跟原有类的层级关系
        // 采用装饰器模式
        //装饰器模式实际上一种非常特殊的适配器模式

        //虽然DataInputStream功能更加强大
        //DataInputStream 同样要实现inputStream
        InputStream in = null;
        FilterInputStream fis = new DataInputStream(in);
    }

}
