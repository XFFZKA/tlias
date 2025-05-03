package com.itheima.controller;

import com.itheima.anno.Log;
import com.itheima.pojo.Dept;
import com.itheima.pojo.Emp;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/depts")
    public Result list() {
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    @Log
    @DeleteMapping("/depts/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("Delete dept with id {}", id);
        deptService.delete(id);
        Result result = new Result();
        return Result.success();
    }

    @Log
    @PostMapping("/depts")
    public Result add(@RequestBody Dept dept) {
        log.info("Add dept {}", dept);
        deptService.add(dept);
        Result result = new Result();
        return Result.success();
    }

    @GetMapping("/depts/{id}")
    public Result get(@PathVariable Integer id) {
        log.info("Get dept with id {}", id);
        Dept dept = deptService.get(id);
        Result result = new Result();
        return Result.success(dept);
    }

    @Log
    @PutMapping("/depts")
    public Result update(@RequestBody Dept dept) {
        log.info("Update dept with id {}", dept);

        deptService.update(dept);
        return Result.success();
    }

}
