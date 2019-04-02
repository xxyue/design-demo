package com.design.designdemo.creating._1factory.abstr;

import com.design.designdemo.creating._1factory.Milk;
import com.design.designdemo.creating._1factory.Yili;
import com.design.designdemo.creating._1factory.func.MilkFuncFactory;

/**
 * @Description: ${description}
 * @ClassName: YiliFactory
 * @Author: yuexx
 * @Date: 2019/1/24 14:13
 * @Version: 1.0
 */
public class YiliFactory implements MilkFuncFactory {

    @Override
    public Milk getMilk() {
        return new Yili();
    }
}
