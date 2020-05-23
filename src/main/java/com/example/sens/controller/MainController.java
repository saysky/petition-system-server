package com.example.sens.controller;

import com.example.sens.config.annotation.SystemLog;
import com.example.sens.enums.LogTypeEnum;
import com.example.sens.util.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 言曌
 * @date 2019-05-08 13:36
 */

@Controller
public class MainController {

    public static final String prefix = "http://localhost:8080";

    @GetMapping("/")
    public String index() {
        return "redirect:/static/index.html";
    }

    @GetMapping("/login")
    public String login() {
        return "redirect:/static/index.html#/login";
    }

    @GetMapping("/adminLogin")
    public String adminLogin() {
        return "redirect:/static/index.html#/adminLogin";
    }




    @PostMapping(value = "/api/file/upload", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    @SystemLog(type = LogTypeEnum.UPLOAD_FILE)
    public Map<String, Object> uploadFile(@RequestParam("file") MultipartFile file) {
        Map<String, Object> map = new HashMap<>();
        String path = null;
        try {
            path = FileUtil.upload(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put("path", prefix + path);
        return map;
    }
}
