package com.design.designdemo.creating._3prototype;

import java.util.ArrayList;

/**
 * @Description: 浅克隆
 * @ClassName: ClonePrototye
 * @Author: yuexx
 * @Date: 2019/1/28 14:51
 * @Version: 1.0
 */
public class ClonePrototye1 implements Cloneable {
    public String name;
    public ArrayList<CloneTarget> list;
    public CloneTarget target;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
