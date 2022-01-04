package com.cqupt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jingdong
 * @description:
 * @menu
 * @date 2021/12/2 15:27
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/employee/basic/hello")
    public String helloBasic(){
        return "/employee/basic/hello";
    }

    @GetMapping("employee/advanced/hello")
    public String helloAdvanced(){
        return "/employee/advanced/hello";
    }
}
