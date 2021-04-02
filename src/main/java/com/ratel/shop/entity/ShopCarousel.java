package com.ratel.shop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * 轮播
 */
@Data
@Builder
@TableName("t_shop_carousel")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ShopCarousel extends BaseEntity {

    private String carouselUrl;

    private String redirectUrl;

    private Integer carouselRank;

    private Byte isDeleted;

    private Integer createUser;

    private Integer updateUser;
}