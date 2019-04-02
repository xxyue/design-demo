package com.design.designdemo.behavior._3observer.core;

import java.lang.reflect.Method;

/**
 * @Description: ${description}
 * @ClassName: Event
 * @Author: yuexx
 * @Date: 2019/2/13 15:47
 * @Version: 1.0
 */
public class Event {
    //事件源
    private Object source;
    //通知目标
    private Object target;
    //回调
    private Method callback;
    //触发
    private String trigger;

    private long time;

    public Event(Object target, Method callback) {
        this.target = target;
        this.callback = callback;
    }

    public Object getSource() {
        return source;
    }

    public Object getTarget() {
        return target;
    }

    public Event setTarget(Object target) {
        this.target = target;
        return this;
    }

    public Method getCallback() {
        return callback;
    }

    public Event setCallback(Method callback) {
        this.callback = callback;
        return this;
    }

    public String getTrigger() {
        return trigger;
    }

    @Override
    public String toString() {
        return "Event{" +
                "\n\tsource=" + source +
                ", \n\ttarget=" + target +
                ",\n\t callback=" + callback +
                ",\n\t trigger='" + trigger + '\'' +
                '}';
    }

    Event setSource(Object source) {
        this.source = source;
        return this;
    }

    Event setTrigger(String trigger) {
        this.trigger = trigger;
        return this;
    }

    public long getTime() {

        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
