package com.itheima.service;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DeptService {



    public List<Dept> list();
    public void delete(Integer id);

    void add(Dept dept);

    void update(Dept dept);

    Dept get(Integer id);
}
