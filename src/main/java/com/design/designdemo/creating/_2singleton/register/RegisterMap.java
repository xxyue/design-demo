package com.design.designdemo.creating._2singleton.register;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description: 注册时单例
 * @ClassName: RegusterMap
 * @Author: yuexx
 * @Date: 2019/1/28 10:47
 * @Version: 1.0
 */
public class RegisterMap {
    private RegisterMap(){
    }

    private  static Map<String, Object> register = new ConcurrentHashMap<String, Object>();

    public static RegisterMap getInstance(String name){
        if(name == null){
            name = RegisterMap.class.getName();
        }
        if(register.get(name) == null){
            try {
                register.put(name, new RegisterMap());
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return  (RegisterMap)register.get(name);
    }
}
