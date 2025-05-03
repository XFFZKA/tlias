package com.itheima.controller;

import com.itheima.anno.Log;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@Slf4j
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping("/emps")
    public Result page(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize
                        , String name, Short gender, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
        log.info("123456");

        PageBean pageBean = empService.page(page,pageSize,name,gender,begin,end);
        return Result.success(pageBean);

    }

    @Log
    @DeleteMapping("/emps/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        log.info("123456");
        empService.delete(ids);
        return Result.success();
    }

    @Log
    @PostMapping("/emps")
    public Result save(@RequestBody Emp emp) {
        log.info("emp{}",emp);

        empService.save(emp);
        return Result.success();
    }

    @GetMapping("/emps/{id}")
    public Result getEmpById(@PathVariable Integer id) {
        log.info("emp{}",id);
        Emp emp = empService.getEmpById(id);
        return Result.success(emp);
    }

    @Log
    @PutMapping("/emps")
    public Result update(@RequestBody Emp emp) {
        log.info("emp{}",emp);
        empService.update(emp);
        return Result.success();
    }

}
