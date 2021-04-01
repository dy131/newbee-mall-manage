package com.ratel.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ratel.shop.entity.GoodsCategory;
import com.ratel.shop.util.PageQueryUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsCategoryMapper extends BaseMapper<GoodsCategory> {

    List<GoodsCategory> queryGoodsCategoryPageList(PageQueryUtil pageQueryUtil);

    int queryGoodsCategoryCount(PageQueryUtil pageQueryUtil);

    List<GoodsCategory> queryShopCategoryLevelByParentId(@Param("parentIds") List<Long> parentIds, @Param("categoryLevel") int categoryLevel);

    int deleteByPrimaryKey(Long categoryId);


    int insertSelective(GoodsCategory record);

    GoodsCategory selectByPrimaryKey(Long categoryId);

    GoodsCategory selectByLevelAndName(@Param("categoryLevel") Integer categoryLevel, @Param("categoryName") String categoryName);

    int updateByPrimaryKeySelective(GoodsCategory record);

    int updateByPrimaryKey(GoodsCategory record);



    int deleteBatch(Integer[] ids);


}