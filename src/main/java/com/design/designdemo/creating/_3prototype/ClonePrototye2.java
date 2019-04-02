package com.design.designdemo.creating._3prototype;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

/**
 * @Description: 深克隆
 * @ClassName: ClonePrototye
 * @Author: yuexx
 * @Date: 2019/1/28 14:51
 * @Version: 1.0
 */
public class ClonePrototye2 implements Cloneable, Serializable{
    public String name;

    public ArrayList<CloneTarget> list;

    public CloneTarget target;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return deepClone();
    }

    private ClonePrototye2 deepClone() {

        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            ClonePrototye2 clone = (ClonePrototye2) ois.readObject();
            //如果要修改值，手动修改， 深度拷贝只是每个属性地址是新的
            clone.target.birthday = new Date();
            return clone;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
