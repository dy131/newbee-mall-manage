package com.ratel.shop.service;

import com.ratel.shop.entity.ShopOrder;
import com.ratel.shop.entity.ShopOrderItem;
import com.ratel.shop.util.PageQueryUtil;
import com.ratel.shop.util.PageResult;

import java.util.List;

public interface ShopOrderService {

    PageResult queryShopOrderPageList(PageQueryUtil pageQueryUtil);

    String updateShopOrder(ShopOrder shopOrder);

    List<ShopOrderItem> queryOrderDetailByOrderId(Long orderId);

    String updateOrderAllotStatus(Long[] orderIds);

    String updateOrderOutStatus(Long[] orderIds);

    String updateOrderCloseStatus(Long[] orderIds);
}
