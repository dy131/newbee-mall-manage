package com.ratel.shop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

/**
 * 轮播
 */
@Data
@Builder
@TableName("t_carousel")
public class Carousel extends BaseEntity {

    private String carouselUrl;

    private String redirectUrl;

    private Integer carouselRank;

    private Byte isDeleted;

    private Integer createUser;

    private Integer updateUser;
}