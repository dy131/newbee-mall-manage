package com.ratel.shop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@TableName("t_shop_goods")
public class ShopGoods extends BaseEntity {

    private Long goodsId;

    private String goodsName;

    private String goodsIntro;

    private Long goodsCategoryId;

    private String goodsCoverImg;

    private String goodsCarousel;

    private Integer originalPrice;

    private Integer sellingPrice;

    private Integer stockNum;

    private String tag;

    private Byte goodsSellStatus;

    private String goodsDetailContent;
}