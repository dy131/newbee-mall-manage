package com.ratel.shop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@TableName("t_shop_order")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ShopOrder extends BaseEntity{

    private Long orderId;

    private String orderNo;

    private Long userId;

    private BigDecimal totalPrice;

    private Integer payStatus;

    private Integer payType;

    private Date payTime;

    private Integer orderStatus;

    private String extraInfo;

    private Integer isDeleted;
}