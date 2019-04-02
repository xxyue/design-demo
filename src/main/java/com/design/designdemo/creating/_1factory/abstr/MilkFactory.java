package com.design.designdemo.creating._1factory.abstr;

import com.design.designdemo.creating._1factory.Milk;

/**
 * @Description: ${description}
 * @ClassName: MilkFactory
 * @Author: yuexx
 * @Date: 2019/1/24 15:06
 * @Version: 1.0
 */
public class MilkFactory extends AbstactMilkFactory {

    @Override
    public Milk getMengniu() {
        return new MengniuFactory().getMilk();
    }

    @Override
    public Milk getTelunsu() {
        return new YiliFactory().getMilk();
    }

    @Override
    public Milk getYili() {
        return new YiliFactory().getMilk();
    }
}
