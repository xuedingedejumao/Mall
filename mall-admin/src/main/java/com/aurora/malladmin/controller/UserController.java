package com.aurora.malladmin.controller;

import com.aurora.malladmin.service.UserService;
import com.aurora.mallcommon.api.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

//    @PostMapping("/login")
//    @ResponseBody
//    public R login(@RequestParam(value = "code",required = false)String code){
//
//        return R.success();
//    }

    @PostMapping("/register")
    @ResponseBody
    public R register(@RequestParam(value = "code",required = false)String code){
        userService.register(code);
        return R.success("ok");
    }

    @PostMapping("/login")
    @ResponseBody
    public R login(@RequestParam(value = "code",required = false)String code){
        String token = userService.register(code);
        System.out.println(code);
        if(token != ""){
            return R.success(token);
        }else {
            return R.failed("用户已存在");
        }
    }
}
