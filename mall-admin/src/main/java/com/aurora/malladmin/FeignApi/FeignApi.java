package com.aurora.malladmin.FeignApi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "mall-common")
public interface FeignApi {

    @RequestMapping("/feign/generateToken")
    String createToken(String openId);
}
