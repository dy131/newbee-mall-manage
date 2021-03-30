package com.ratel.shop.service;

import com.ratel.shop.entity.GoodsCategory;
import com.ratel.shop.util.PageQueryUtil;
import com.ratel.shop.util.PageResult;

import java.util.List;

public interface ShopCategoryService {
    /**
     * 后台分页
     *
     * @param pageUtil
     * @return
     */
    PageResult getCategorisPage(PageQueryUtil pageUtil);

    String saveCategory(GoodsCategory goodsCategory);

    String updateGoodsCategory(GoodsCategory goodsCategory);

    GoodsCategory getGoodsCategoryById(Long id);

    Boolean deleteBatch(Integer[] ids);

    List<GoodsCategory> queryShopCategoryLevelByParentId(List<Long> parentIds, int categoryLevel);
}
