package com.ratel.shop.service;

import com.ratel.shop.entity.ShopOrderItem;
import com.ratel.shop.util.PageQueryUtil;
import com.ratel.shop.util.PageResult;
import com.ratel.shop.entity.ShopOrder;

import java.util.List;

public interface ShopOrderService {

    PageResult getNewBeeMallOrdersPage(PageQueryUtil pageUtil);

    /**
     * 订单信息修改
     */
    String updateOrderInfo(ShopOrder newBeeMallOrder);

    /**
     * 配货
     */
    String checkDone(Long[] ids);

    /**
     * 出库
     */
    String checkOut(Long[] ids);

    /**
     * 关闭订单
     */
    String closeOrder(Long[] ids);

    List<ShopOrderItem> getOrderItems(Long id);
}
