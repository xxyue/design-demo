package com.design.designdemo.creating._3prototype;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * @Description: ${description}
 * @ClassName: ClonePrototye
 * @Author: yuexx
 * @Date: 2019/1/28 14:51
 * @Version: 1.0
 */
public class CloneTarget implements Cloneable, Serializable {
    public String name;

    public ArrayList<String> list;

    public Date birthday;

    public CloneTarget(){
        this.birthday = new Date();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
