package com.ratel.shop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@TableName("t_user")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

    private String userName;

    private String password;

    private String nickName;

    private Integer locked;
}