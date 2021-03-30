package com.ratel.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ratel.shop.entity.ShopOrder;
import com.ratel.shop.util.PageQueryUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopOrderMapper extends BaseMapper<ShopOrder> {
    int deleteByPrimaryKey(Long orderId);

    int insert(ShopOrder record);

    int insertSelective(ShopOrder record);

    ShopOrder selectByPrimaryKey(Long orderId);

    ShopOrder selectByOrderNo(String orderNo);

    int updateByPrimaryKeySelective(ShopOrder record);

    int updateByPrimaryKey(ShopOrder record);

    List<ShopOrder> findNewBeeMallOrderList(PageQueryUtil pageUtil);

    int getTotalNewBeeMallOrders(PageQueryUtil pageUtil);

    List<ShopOrder> selectByPrimaryKeys(@Param("orderIds") List<Long> orderIds);

    int checkOut(@Param("orderIds") List<Long> orderIds);

    int closeOrder(@Param("orderIds") List<Long> orderIds, @Param("orderStatus") int orderStatus);

    int checkDone(@Param("orderIds") List<Long> asList);
}