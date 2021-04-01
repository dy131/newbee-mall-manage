package com.ratel.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ratel.shop.entity.ShopOrder;
import com.ratel.shop.util.PageQueryUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopOrderMapper extends BaseMapper<ShopOrder> {

    List<ShopOrder> queryShopOrderPageList(PageQueryUtil pageQueryUtil);

    int queryShopOrderPageCount(PageQueryUtil pageQueryUtil);

    List<ShopOrder> queryShopOrderByOrderIds(@Param("orderIds") List<Long> orderIds);

    int updateOrderAllotStatus(@Param("orderIds") List<Long> orderIds);

    int updateOrderOutStatus(@Param("orderIds") List<Long> orderIds);

    int updateOrderCloseStatus(@Param("orderIds") List<Long> orderIds, @Param("orderStatus") int orderStatus);

    int deleteByPrimaryKey(Long orderId);

    int insert(ShopOrder record);

    int insertSelective(ShopOrder record);

    ShopOrder selectByPrimaryKey(Long orderId);

    ShopOrder selectByOrderNo(String orderNo);

    int updateByPrimaryKeySelective(ShopOrder record);

    int updateByPrimaryKey(ShopOrder record);


}