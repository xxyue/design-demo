package com.design.designdemo.behavior._2template;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: ${description}
 * @ClassName: MyTemlate
 * @Author: yuexx
 * @Date: 2019/1/30 16:40
 * @Version: 1.0
 */
public class MyJdbcTemlate1 {

    private DataSource dataSource;

    public MyJdbcTemlate1(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Object> executeQuery(String sql, RowMapper1<?> rowMapper, Object[] values) {
        try {
            //1.获取连接
            Connection conn = this.getConnection();
            //2.创建语句集
            PreparedStatement pstmt = this.createPreparedStatement(conn, sql);
            //3.执行语句集，并且获得结果集
            ResultSet rs = this.executeQuery(pstmt, values);
            //4、解析结果集
//            List<Object> result = new ArrayList<Object>();
//            int rowNum = 1;
//            while (rs.next()) {
//                result.add(rowMapper.processResult(rs, rowNum++));
//            }
            this.processResult(rs, rowMapper);
            //5、关闭结果集
            this.closeResult(rs);
            //6.关闭语句集
            this.closeStatement(pstmt);
            //7.关闭连接
            this.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 1.获取连接
     *
     * @return
     * @throws Exception
     */
    private Connection getConnection() throws Exception {
        return this.dataSource.getConnection();
    }

    /**
     * 2.创建语句集
     *
     * @param conn
     * @param sql
     * @return
     * @throws Exception
     */
    private PreparedStatement createPreparedStatement(Connection conn, String sql) throws Exception {
        return conn.prepareStatement(sql);
    }

    /**
     * 3.执行语句集，并且获得结果集
     *
     * @param pstmt
     * @param values
     * @return
     * @throws Exception
     */
    private ResultSet executeQuery(PreparedStatement pstmt, Object[] values) throws Exception {
        for (int i = 0; i < values.length; i++) {
            pstmt.setObject(i, values[i]);
        }
        return pstmt.executeQuery();
    }

    //4、解析结果集
//    public abstract Object processResult(ResultSet rs, int rowNum) throws Exception;
    private List<?> processResult(ResultSet rs, RowMapper1<?> rowMapper) throws Exception {
        List<Object> result = new ArrayList<Object>();
        int rowNum = 1;
        while (rs.next()) {
            result.add(rowMapper.processResult(rs, rowNum++));
        }
        return result;
    }

    //5、关闭结果集
    private void closeStatement(Statement stmt) throws Exception {
        stmt.close();
    }

    //6.关闭语句集
    private void closeResult(ResultSet rs) throws Exception {
        rs.close();
    }

    //7.关闭连接
    private void closeConnection(Connection conn) throws Exception {
//        conn.close();
        //通常不关闭 ，放回连接池中回收
    }

}
