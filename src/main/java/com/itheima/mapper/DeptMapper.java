package com.itheima.mapper;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {

    @Select("SELECT * FROM dept")
    List<Dept> list();


    @Delete("delete from dept where id = #{id}")
    void delete(Integer id);

    @Insert("insert into dept(NAME, CREATE_TIME, UPDATE_TIME) values(#{name},#{createTime},#{updateTime})")
    void add(Dept dept);

    @Update("update dept set name=#{name},update_time=#{updateTime} where id=#{id}")
    void update(Dept dept);

    @Select("select * from dept where id = #{id}")
    Dept get(Integer id);


}
