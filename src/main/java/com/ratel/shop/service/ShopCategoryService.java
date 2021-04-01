package com.ratel.shop.service;

import com.ratel.shop.entity.GoodsCategory;
import com.ratel.shop.util.PageQueryUtil;
import com.ratel.shop.util.PageResult;

import java.util.List;

public interface ShopCategoryService {

    PageResult getGoodsCategoryPageList(PageQueryUtil pageQueryUtil);

    String insertGoodsCategory(GoodsCategory goodsCategory);

    String updateGoodsCategory(GoodsCategory goodsCategory);

    GoodsCategory queryGoodsCategoryById(Long categoryId);


    Boolean deleteBatch(Integer[] ids);

    List<GoodsCategory> queryShopCategoryLevelByParentId(List<Long> parentIds, int categoryLevel);
}
