package com.aurora.malladmin.dao.mapper;

import com.aurora.malladmin.dao.base.BaseDao;
import com.aurora.malladmin.dto.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface UserDao extends BaseDao<User> {
//    void deleteByMemberStatues(@Param("userId") String userId);
//    User queryById(@Param("userId")String userId);

    User selectUserByOpenId(@Param("openId")String openId);
}