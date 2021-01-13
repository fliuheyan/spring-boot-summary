package com.cloud.mybatis.mapper;

import com.cloud.mybatis.model.Application;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface ApplicationMapper {
    @Insert("insert into t_application(name, price, create_time, update_time) "
            + "values(#{name}, #{price}, now(), now())")
    @Options(useGeneratedKeys = true)
    int save(Application application);

    @Select("select * from t_application")
    @Results(id = "application", value = {
            //column 数据库字段名，property class字段名
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP)
    })
    List<Application> findAll();
}
