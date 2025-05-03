package com.itheima.controller;


import com.itheima.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


@Slf4j
@RestController
public class UploadController {


    @PostMapping("/upload")
    public Result upload(String username, Integer age, MultipartFile image) throws IOException {
        log.info("{},{},{}", username, age, image);



        String originFileName = image.getOriginalFilename();

        String newFileName = UUID.randomUUID().toString() + originFileName.substring(originFileName.lastIndexOf("."));
        image.transferTo(new File("C:\\Users\\32014\\IdeaProjects\\tlias-web-management\\images\\"+newFileName));

        return Result.success();
    }


}
