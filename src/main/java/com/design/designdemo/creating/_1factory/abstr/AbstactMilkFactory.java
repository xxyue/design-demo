package com.design.designdemo.creating._1factory.abstr;

import com.design.designdemo.creating._1factory.Milk;

/**
 * @Description: 抽象工厂
 * @ClassName: AbstactFactory
 * @Author: yuexx
 * @Date: 2019/1/24 14:21
 * @Version: 1.0
 */
public abstract class AbstactMilkFactory {

    /**
     *
     * @return
     */
    public abstract Milk getMengniu();

    /**
     *
     * @return
     */
    public abstract Milk getTelunsu();

    /**
     *
     * @return
     */
    public abstract Milk getYili();

}
