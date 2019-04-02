package com.design.designdemo.behavior._3observer.subject;

import com.design.designdemo.behavior._3observer.core.Event;

/**
 * @Description: ${description}
 * @ClassName: Observer
 * @Author: yuexx
 * @Date: 2019/2/13 15:45
 * @Version: 1.0
 */
public class Observer {
    
    public void advice(Event event){
        System.out.println("===============触发事件，打印日志==================");
        System.out.println(event.toString());
    }
}
