package com.design.designdemo.structural._1proxy.static_;

/**
 * @Description: ${description}
 * @ClassName: Father
 * @Author: yuexx
 * @Date: 2019/1/29 15:39
 * @Version: 1.0
 */
public class Father {

    private Son son;

    public Father(Son son) {
        this.son = son;
    }

    //
    public void findLove() {
        System.out.println("根据需求干一些事，找一个女的给你");
        son.findLove();
        System.out.println("做之后的事情处理，结婚什么的");

    }
}
