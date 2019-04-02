package com.design.designdemo.behavior._2template.dao;

import org.junit.Test;

/**
 * @Description: ${description}
 * @ClassName: MemberDaoTest
 * @Author: yuexx
 * @Date: 2019/1/30 17:08
 * @Version: 1.0
 */
public class MemberDaoTest {

    @Test
    public void processResult() {
        MemberDao0 memberDao = new MemberDao0(null);
        memberDao.query();
    }
}