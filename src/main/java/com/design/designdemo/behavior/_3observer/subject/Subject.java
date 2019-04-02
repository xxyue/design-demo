package com.design.designdemo.behavior._3observer.subject;

import com.design.designdemo.behavior._3observer.core.EvenLisenter;

/**
 * @Description: ${description}
 * @ClassName: Subject
 * @Author: yuexx
 * @Date: 2019/2/13 15:43
 * @Version: 1.0
 */
public class Subject extends EvenLisenter {


    //通常 采用动态代理实现监控，避免代码侵入
    public void add(){
        System.out.println("调用添加方法");
        trigger(SubjectEventType.ON_ADD);
    }

    public void remove(){
        System.out.println("调用删除方法");
        trigger(SubjectEventType.ON_REMOVE);
    }
}
