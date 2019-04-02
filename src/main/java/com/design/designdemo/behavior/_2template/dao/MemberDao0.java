package com.design.designdemo.behavior._2template.dao;

import com.design.designdemo.behavior._2template.MyJdbcTemlate0;
import com.design.designdemo.behavior._2template.entity.Member;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

/**
 * @Description: ${description}
 * @ClassName: MemberDao
 * @Author: yuexx
 * @Date: 2019/1/30 16:56
 * @Version: 1.0
 */
public class MemberDao0 extends MyJdbcTemlate0 {

    public MemberDao0(DataSource dataSource) {
        super(dataSource);
    }

    public List<Object> query(){
        String  sql = "select * from t_member";
        return super.executeQuery(sql, null);
    }

    @Override
    public Object processResult(ResultSet rs, int rowNum) throws Exception {
        Member member = new Member();
        member.setUserName(rs.getString("username"));
        member.setPassWord(rs.getString("passWord"));
        member.setNickName(rs.getString("nickName"));
        member.setAge(rs.getInt("age"));
        member.setAddr(rs.getString("addr"));
        return member;
    }
}
