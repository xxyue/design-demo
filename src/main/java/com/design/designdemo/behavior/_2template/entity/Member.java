package com.design.designdemo.behavior._2template.entity;

/**
 * @Description: ${description}
 * @ClassName: Menber
 * @Author: yuexx
 * @Date: 2019/1/30 16:53
 * @Version: 1.0
 */
public class Member {

    private String userName;
    private String passWord;
    private String nickName;
    private int age;
    private String addr;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
