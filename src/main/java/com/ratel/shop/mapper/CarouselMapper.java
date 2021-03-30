package com.ratel.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ratel.shop.entity.Carousel;
import com.ratel.shop.util.PageQueryUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarouselMapper extends BaseMapper<Carousel> {
    int deleteByPrimaryKey(Integer carouselId);

    int insert(Carousel record);

    int insertSelective(Carousel record);

    Carousel selectByPrimaryKey(Integer carouselId);

    int updateByPrimaryKeySelective(Carousel record);

    int updateByPrimaryKey(Carousel record);

    List<Carousel> findCarouselList(PageQueryUtil pageUtil);

    int getTotalCarousels(PageQueryUtil pageUtil);

    int deleteBatch(Integer[] ids);

    List<Carousel> findCarouselsByNum(@Param("number") int number);
}