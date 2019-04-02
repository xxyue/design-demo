package com.design.designdemo.behavior._2template;

import java.sql.ResultSet;

/**
 * @Description: ${description}
 * @ClassName: RowMaper
 * @Author: yuexx
 * @Date: 2019/1/30 17:29
 * @Version: 1.0
 */
public interface RowMapper1<T> {
    public T processResult(ResultSet rs, int rowNum) throws Exception;
}
