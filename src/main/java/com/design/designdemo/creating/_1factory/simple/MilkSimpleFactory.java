package com.design.designdemo.creating._1factory.simple;

import com.design.designdemo.creating._1factory.Mengniu;
import com.design.designdemo.creating._1factory.Milk;
import com.design.designdemo.creating._1factory.Telunsu;
import com.design.designdemo.creating._1factory.Yili;

/**
 * @Description: ${description}
 * @ClassName: SimpleFactory
 * @Author: yuexx
 * @Date: 2019/1/24 11:55
 * @Version: 1.0
 */
public class MilkSimpleFactory {

    public Milk getMilk(String name){
        //需要穷举多有可能
        if("特仑苏".equals(name)){
            return new Telunsu();
        } else if("伊利".equals(name)){
            return new Yili();
        } else  if("蒙牛".equals(name)){
            return new Mengniu();
        } else {
            System.out.println("不能生产您所需要的产品" + name);
        }
        return null;
    }
}
