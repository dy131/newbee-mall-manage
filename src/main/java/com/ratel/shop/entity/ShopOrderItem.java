package com.ratel.shop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@TableName("t_shop_order_item")
public class ShopOrderItem {

    private Long orderItemId;

    private Long orderId;

    private Long goodsId;

    private String goodsName;

    private String goodsCoverImg;

    private Integer sellingPrice;

    private Integer goodsCount;
}