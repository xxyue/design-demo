package com.design.designdemo.behavior._2template.dao;

import com.design.designdemo.behavior._2template.MyJdbcTemlate0;
import com.design.designdemo.behavior._2template.MyJdbcTemlate1;
import com.design.designdemo.behavior._2template.RowMapper1;
import com.design.designdemo.behavior._2template.entity.Member;

import java.sql.ResultSet;
import java.util.List;

/**
 * @Description: ${description}
 * @ClassName: MemberDao
 * @Author: yuexx
 * @Date: 2019/1/30 16:56
 * @Version: 1.0
 */
public class MemberDao1 {

    private MyJdbcTemlate1 jdbcTemlate = new MyJdbcTemlate1(null);

    public List<Object> query() {
        String sql = "select * from t_member";
        return jdbcTemlate.executeQuery(sql,
                new RowMapper1<Member>() {
                    @Override
                    public Member processResult(ResultSet rs, int rowNum) throws Exception {
                        Member member = new Member();
                        member.setUserName(rs.getString("username"));
                        member.setPassWord(rs.getString("passWord"));
                        member.setNickName(rs.getString("nickName"));
                        member.setAge(rs.getInt("age"));
                        member.setAddr(rs.getString("addr"));
                        return member;
                    }
                },
                null);
    }


}
