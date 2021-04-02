package com.ratel.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ratel.shop.entity.User;
import com.ratel.shop.mapper.UserMapper;
import com.ratel.shop.service.UserService;
import com.ratel.shop.util.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User login(String userName, String password) {
        String passwordMd5 = MD5Util.MD5Encode(password, "UTF-8");
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", userName);
        queryWrapper.eq("password", passwordMd5);
        return userMapper.selectOne(queryWrapper);
    }

    @Override
    public User queryUserById(Long userId) {
        return userMapper.selectById(userId);
    }

    @Override
    public Boolean updatePassword(Long userId, String originalPassword, String newPassword) {
        User user = userMapper.selectById(userId);
        if (user != null) {
            String originalPasswordMd5 = MD5Util.MD5Encode(originalPassword, "UTF-8");
            String newPasswordMd5 = MD5Util.MD5Encode(newPassword, "UTF-8");
            if (originalPasswordMd5.equals(user.getPassword())) {
                user.setPassword(newPasswordMd5);
                if (userMapper.updateById(user) > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Boolean updateName(Long userId, String userName, String nickName) {
        User user = userMapper.selectById(userId);
        if (user != null) {
            user.setUserName(userName);
            user.setNickName(nickName);
            if (userMapper.updateById(user) > 0) {
                return true;
            }
        }
        return false;
    }
}
