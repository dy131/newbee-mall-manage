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
    public User getUserDetailById(Integer loginUserId) {
        return userMapper.selectByPrimaryKey(loginUserId);
    }

    @Override
    public Boolean updatePassword(Integer loginUserId, String originalPassword, String newPassword) {
        User adminUser = userMapper.selectByPrimaryKey(loginUserId);
        //当前用户非空才可以进行更改
        if (adminUser != null) {
            String originalPasswordMd5 = MD5Util.MD5Encode(originalPassword, "UTF-8");
            String newPasswordMd5 = MD5Util.MD5Encode(newPassword, "UTF-8");
            //比较原密码是否正确
            if (originalPasswordMd5.equals(adminUser.getPassword())) {
                //设置新密码并修改
                adminUser.setPassword(newPasswordMd5);
                if (userMapper.updateByPrimaryKeySelective(adminUser) > 0) {
                    //修改成功则返回true
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Boolean updateName(Integer loginUserId, String loginUserName, String nickName) {
        User adminUser = userMapper.selectByPrimaryKey(loginUserId);
        //当前用户非空才可以进行更改
        if (adminUser != null) {
            //设置新名称并修改
            adminUser.setUserName(loginUserName);
            adminUser.setNickName(nickName);
            if (userMapper.updateByPrimaryKeySelective(adminUser) > 0) {
                //修改成功则返回true
                return true;
            }
        }
        return false;
    }
}
