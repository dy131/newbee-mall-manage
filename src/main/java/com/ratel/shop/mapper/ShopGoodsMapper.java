package com.ratel.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ratel.shop.entity.ShopGoods;
import com.ratel.shop.entity.StockNumDTO;
import com.ratel.shop.util.PageQueryUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopGoodsMapper extends BaseMapper<ShopGoods> {

    List<ShopGoods> queryRatelShopGoodsPageList(PageQueryUtil pageQueryUtil);

    int deleteByPrimaryKey(Long goodsId);

    ShopGoods selectByPrimaryKey(Long goodsId);

    int updateByPrimaryKeySelective(ShopGoods record);

    int updateByPrimaryKeyWithBLOBs(ShopGoods record);

    int updateByPrimaryKey(ShopGoods record);

    int getTotalNewBeeMallGoods(PageQueryUtil pageUtil);

    List<ShopGoods> selectByPrimaryKeys(List<Long> goodsIds);

    List<ShopGoods> findNewBeeMallGoodsListBySearch(PageQueryUtil pageUtil);

    int getTotalNewBeeMallGoodsBySearch(PageQueryUtil pageUtil);

    int batchInsert(@Param("newBeeMallGoodsList") List<ShopGoods> newBeeMallGoodsList);

    int updateStockNum(@Param("stockNumDTOS") List<StockNumDTO> stockNumDTOS);

    int batchUpdateSellStatus(@Param("orderIds") Long[] orderIds, @Param("sellStatus") int sellStatus);

}