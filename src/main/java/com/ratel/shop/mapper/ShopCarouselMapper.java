package com.ratel.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ratel.shop.entity.ShopCarousel;
import com.ratel.shop.util.PageQueryUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopCarouselMapper extends BaseMapper<ShopCarousel> {

    List<ShopCarousel> queryShopCarouselPageList(PageQueryUtil pageQueryUtil);

    int queryShopCarouselPageCount(PageQueryUtil pageQueryUtil);




    int deleteByPrimaryKey(Integer carouselId);

    int insertSelective(ShopCarousel record);

    ShopCarousel selectByPrimaryKey(Integer carouselId);

    int updateByPrimaryKeySelective(ShopCarousel record);

    int updateByPrimaryKey(ShopCarousel record);




    int deleteBatch(Integer[] ids);

    List<ShopCarousel> findCarouselsByNum(@Param("number") int number);
}