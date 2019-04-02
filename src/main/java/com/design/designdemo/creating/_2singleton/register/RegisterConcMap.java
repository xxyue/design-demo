package com.design.designdemo.creating._2singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description: 注册时单例
 * @ClassName: RegusterMap
 * @Author: yuexx
 * @Date: 2019/1/28 10:47
 * @Version: 1.0
 */
public class RegisterConcMap {
    private RegisterConcMap() {
    }

    private static Map<String, Object> ioc = new ConcurrentHashMap<String, Object>();

    public static synchronized Object getBean(String className) {
        if (ioc.containsKey(className)) {
            return ioc.get(className);
        } else {
            try {
                Object obj = Class.forName(className).newInstance();
                ioc.put(className, obj);
                return obj;
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
