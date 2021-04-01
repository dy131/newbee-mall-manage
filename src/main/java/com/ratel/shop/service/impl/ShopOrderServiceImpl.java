package com.ratel.shop.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ratel.shop.common.ServiceResultEnum;
import com.ratel.shop.common.ShopOrderStatusEnum;
import com.ratel.shop.entity.ShopOrder;
import com.ratel.shop.entity.ShopOrderItem;
import com.ratel.shop.mapper.ShopOrderItemMapper;
import com.ratel.shop.mapper.ShopOrderMapper;
import com.ratel.shop.service.ShopOrderService;
import com.ratel.shop.util.PageQueryUtil;
import com.ratel.shop.util.PageResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class ShopOrderServiceImpl implements ShopOrderService {

    @Resource
    private ShopOrderMapper shopOrderMapper;
    @Resource
    private ShopOrderItemMapper shopOrderItemMapper;

    @Override
    public PageResult queryShopOrderPageList(PageQueryUtil pageQueryUtil) {
        List<ShopOrder> shopOrders = shopOrderMapper.queryShopOrderPageList(pageQueryUtil);
        int total = shopOrderMapper.queryShopOrderPageCount(pageQueryUtil);
        PageResult pageResult = new PageResult(shopOrders, total, pageQueryUtil.getLimit(), pageQueryUtil.getPage());
        return pageResult;
    }

    @Override
    @Transactional
    public String updateShopOrder(ShopOrder shopOrder) {
        QueryWrapper<ShopOrder> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("order_id", shopOrder.getOrderId());
        ShopOrder shopOrder1 = shopOrderMapper.selectOne(queryWrapper);
        if (shopOrder1 != null && shopOrder1.getOrderStatus() >= 0 && shopOrder1.getOrderStatus() < 3) {
            shopOrder1.setTotalPrice(shopOrder.getTotalPrice());
            shopOrder1.setUpdateTime(new Date());
            queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("order_id", shopOrder.getOrderId());
            if (shopOrderMapper.update(shopOrder1, queryWrapper) > 0) {
                return ServiceResultEnum.SUCCESS.getResult();
            }
            return ServiceResultEnum.DB_ERROR.getResult();
        }
        return ServiceResultEnum.DATA_NOT_EXIST.getResult();
    }

    @Override
    public List<ShopOrderItem> queryOrderDetailByOrderId(Long orderId) {
        QueryWrapper<ShopOrder> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("order_id", orderId);
        ShopOrder shopOrder = shopOrderMapper.selectOne(queryWrapper);
        if (shopOrder != null) {
            QueryWrapper<ShopOrderItem> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.eq("order_id", shopOrder.getOrderId());
            List<ShopOrderItem> shopOrderItems = shopOrderItemMapper.selectList(queryWrapper1);
            if (!CollectionUtils.isEmpty(shopOrderItems)) {
                return shopOrderItems;
            }
        }
        return null;
    }

    @Override
    @Transactional
    public String updateOrderAllotStatus(Long[] orderIds) {
        List<ShopOrder> shopOrders = shopOrderMapper.queryShopOrderByOrderIds(Arrays.asList(orderIds));
        String errorOrderNos = "";
        if (!CollectionUtils.isEmpty(shopOrders)) {
            for (ShopOrder shopOrder : shopOrders) {
                if (shopOrder.getIsDeleted() == 1) {
                    errorOrderNos += shopOrder.getOrderNo() + " ";
                    continue;
                }
                if (shopOrder.getOrderStatus() != 1) {
                    errorOrderNos += shopOrder.getOrderNo() + " ";
                }
            }
            if (StrUtil.isBlank(errorOrderNos)) {
                if (shopOrderMapper.updateOrderAllotStatus(Arrays.asList(orderIds)) > 0) {
                    return ServiceResultEnum.SUCCESS.getResult();
                } else {
                    return ServiceResultEnum.DB_ERROR.getResult();
                }
            } else {
                if (errorOrderNos.length() > 0 && errorOrderNos.length() < 100) {
                    return errorOrderNos + "订单的状态不是支付成功无法执行出库操作";
                } else {
                    return "你选择了太多状态不是支付成功的订单，无法执行配货完成操作";
                }
            }
        }
        return ServiceResultEnum.DATA_NOT_EXIST.getResult();
    }

    @Override
    @Transactional
    public String updateOrderOutStatus(Long[] orderIds) {
        List<ShopOrder> shopOrders = shopOrderMapper.queryShopOrderByOrderIds(Arrays.asList(orderIds));
        String errorOrderNos = "";
        if (!CollectionUtils.isEmpty(shopOrders)) {
            for (ShopOrder shopOrder : shopOrders) {
                if (shopOrder.getIsDeleted() == 1) {
                    errorOrderNos += shopOrder.getOrderNo() + " ";
                    continue;
                }
                if (shopOrder.getOrderStatus() != 2) {
                    errorOrderNos += shopOrder.getOrderNo() + " ";
                }
            }
            if (StrUtil.isBlank(errorOrderNos)) {
                if (shopOrderMapper.updateOrderOutStatus(Arrays.asList(orderIds)) > 0) {
                    return ServiceResultEnum.SUCCESS.getResult();
                } else {
                    return ServiceResultEnum.DB_ERROR.getResult();
                }
            } else {
                if (errorOrderNos.length() > 0 && errorOrderNos.length() < 100) {
                    return errorOrderNos + "订单的状态不是支付成功或配货完成无法执行出库操作";
                } else {
                    return "你选择了太多状态不是支付成功或配货完成的订单，无法执行出库操作";
                }
            }
        }
        return ServiceResultEnum.DATA_NOT_EXIST.getResult();
    }

    @Override
    @Transactional
    public String updateOrderCloseStatus(Long[] orderIds) {
        List<ShopOrder> shopOrders = shopOrderMapper.queryShopOrderByOrderIds(Arrays.asList(orderIds));
        String errorOrderNos = "";
        if (!CollectionUtils.isEmpty(shopOrders)) {
            for (ShopOrder shopOrder : shopOrders) {
                if (shopOrder.getIsDeleted() == 1) {
                    errorOrderNos += shopOrder.getOrderNo() + " ";
                    continue;
                }
                // 已完成无法关闭订单
                if (shopOrder.getOrderStatus() == 4 || shopOrder.getOrderStatus() < 0) {
                    errorOrderNos += shopOrder.getOrderNo() + " ";
                }
            }
            if (StrUtil.isBlank(errorOrderNos)) {
                if (shopOrderMapper.updateOrderCloseStatus(Arrays.asList(orderIds), ShopOrderStatusEnum.ORDER_CLOSED_BY_JUDGE.getOrderStatus()) > 0) {
                    return ServiceResultEnum.SUCCESS.getResult();
                } else {
                    return ServiceResultEnum.DB_ERROR.getResult();
                }
            } else {
                if (errorOrderNos.length() > 0 && errorOrderNos.length() < 100) {
                    return errorOrderNos + "订单不能执行关闭操作";
                } else {
                    return "你选择的订单不能执行关闭操作";
                }
            }
        }
        //未查询到数据 返回错误提示
        return ServiceResultEnum.DATA_NOT_EXIST.getResult();
    }
}
