package com.aurora.malladmin.service;


import com.alibaba.fastjson.JSONObject;
import com.aurora.malladmin.FeignApi.FeignApi;
import com.aurora.malladmin.dao.mapper.UserDao;
import com.aurora.malladmin.dto.User;
import com.aurora.malladmin.util.DataUtils;
import com.aurora.malladmin.util.WechatUtil;

import com.aurora.mallcommon.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private FeignApi feignApi;

    public String register(String code){
        JSONObject sessionKeyOrOpenId = WechatUtil.getSessionKeyOrOpenId(code);
        String openId = sessionKeyOrOpenId.getString("openid");
        String sessionKey = sessionKeyOrOpenId.getString("session_key");
        if(!isExist(openId)){
            User user = new User();
            user.setOpenId(openId);
            user.setSessionKey(sessionKey);
            user.setLoginStatus("0");
            user.setCreationTime(DataUtils.getSysTimeByFormat("yyyyMMddHHmmss"));
            userDao.insert(user);
            System.out.println("11111111111111");
            return feignApi.createToken(openId);
        }else return "";
    }

    public String login(String token){
        return null;
    }

    public boolean isExist(String openId){
        User user = userDao.selectUserByOpenId(openId);
        if(user == null){
            return false;
        }
        return true;
    }

}
