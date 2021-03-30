package com.ratel.shop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@TableName("t_shop_user")
public class ShopUser extends BaseEntity {

    private Long userId;

    private String nickName;

    private String loginName;

    private String passwordMd5;

    private String introduceSign;

    private Byte isDeleted;

    private Byte lockedFlag;
}