package com.design.designdemo.behavior._3observer.subject;

import com.design.designdemo.behavior._3observer.core.Event;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

/**
 * @Description: ${description}
 * @ClassName: SubjectTest
 * @Author: yuexx
 * @Date: 2019/2/13 16:14
 * @Version: 1.0
 */
@RunWith(JUnit4.class)
public class SubjectTest {

    Observer observer = new Observer();
    Subject subject = new Subject();
    @Before
    public void befor() throws Exception {
        Method advice = Observer.class.getMethod("advice", new Class<?>[]{Event.class});
        subject.addLisenter(SubjectEventType.ON_ADD, observer, advice);
        subject.addLisenter(SubjectEventType.ON_REMOVE, observer, advice);
        subject.addLisenter(SubjectEventType.ON_EDIT, observer, advice);
        subject.addLisenter(SubjectEventType.ON_QUERRY, observer, advice);
    }

    @Test
    public void add(){
        subject.add();
    }

    @Test
    public void remove() {
        subject.remove();
    }
}