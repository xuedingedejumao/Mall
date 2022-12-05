package com.aurora.mallcommon.controller;


import cn.hutool.jwt.JWTUtil;
import com.aurora.mallcommon.util.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/feign")
public class JwtController{

    @Autowired
    JwtUtil jwtUtil;

    @RequestMapping("/generateToken")
    public String generateToken(String openId){
        return jwtUtil.createToken(openId);
    }
}
