package com.amoy.service.admin.controller;


import com.amoy.common.utils.Result;
import com.amoy.service.admin.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("admin/efcttyc7pu")
public class UploadController {

    @Autowired
    UploadService uploadService;
    @PostMapping("/upload")
    public Result upload(@RequestParam(value = "file", required = false)MultipartFile file){
        try {
            return uploadService.imageUpload(file);
        } catch (IOException e) {
            return Result.error(e.getMessage());
        }
    }
}
