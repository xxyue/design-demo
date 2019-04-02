package com.design.designdemo.behavior._3observer.core;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: ${description}
 * @ClassName: EvenLisenter
 * @Author: yuexx
 * @Date: 2019/2/13 15:56
 * @Version: 1.0
 */
public class EvenLisenter {
    protected Map<Enum, Event> events = new HashMap<>();

    public void  addLisenter(Enum eventType, Object target, Method callback) {
       //注册事件
        events.put(eventType,new Event(target, callback));
    }

    private void trigger(Event e){
          e.setSource(this);
          e.setTime(System.currentTimeMillis());
          try {
                e.getCallback().invoke(e.getTarget(),e);
          } catch (Exception es){
              es.printStackTrace();
          }
    }

    protected void trigger (Enum call){
        if(!this.events.containsKey(call)){
            return;
        }
        trigger(this.events.get(call).setTrigger(call.toString()));
    }
}
