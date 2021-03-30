package com.ratel.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ratel.shop.entity.ShopOrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopOrderItemMapper extends BaseMapper<ShopOrderItem> {
    int deleteByPrimaryKey(Long orderItemId);

    int insert(ShopOrderItem record);

    int insertSelective(ShopOrderItem record);

    ShopOrderItem selectByPrimaryKey(Long orderItemId);

    /**
     * 根据订单id获取订单项列表
     *
     * @param orderId
     * @return
     */
    List<ShopOrderItem> selectByOrderId(Long orderId);

    /**
     * 根据订单ids获取订单项列表
     *
     * @param orderIds
     * @return
     */
    List<ShopOrderItem> selectByOrderIds(@Param("orderIds") List<Long> orderIds);

    /**
     * 批量insert订单项数据
     *
     * @param orderItems
     * @return
     */
    int insertBatch(@Param("orderItems") List<ShopOrderItem> orderItems);

    int updateByPrimaryKeySelective(ShopOrderItem record);

    int updateByPrimaryKey(ShopOrderItem record);
}