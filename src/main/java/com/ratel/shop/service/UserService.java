package com.ratel.shop.service;

import com.ratel.shop.entity.User;

public interface UserService {

    User login(String userName, String password);

    /**
     * 获取用户信息
     */
    User getUserDetailById(Integer loginUserId);

    /**
     * 修改当前登录用户的密码
     */
    Boolean updatePassword(Integer loginUserId, String originalPassword, String newPassword);

    /**
     * 修改当前登录用户的名称信息
     */
    Boolean updateName(Integer loginUserId, String loginUserName, String nickName);

}
