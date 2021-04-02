package com.ratel.shop.service;

import com.ratel.shop.entity.User;

public interface UserService {

    User login(String userName, String password);

    User queryUserById(Long userId);

    Boolean updatePassword(Long userId, String originalPassword, String newPassword);

    Boolean updateName(Long userId, String loginUserName, String nickName);

}
