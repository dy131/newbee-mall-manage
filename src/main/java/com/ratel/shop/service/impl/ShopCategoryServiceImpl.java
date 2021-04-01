package com.ratel.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ratel.shop.common.ServiceResultEnum;
import com.ratel.shop.entity.GoodsCategory;
import com.ratel.shop.mapper.GoodsCategoryMapper;
import com.ratel.shop.service.ShopCategoryService;
import com.ratel.shop.util.PageQueryUtil;
import com.ratel.shop.util.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {

    @Resource
    private GoodsCategoryMapper goodsCategoryMapper;

    @Override
    public PageResult getGoodsCategoryPageList(PageQueryUtil pageQueryUtil) {
        List<GoodsCategory> goodsCategoriesList = goodsCategoryMapper.queryGoodsCategoryPageList(pageQueryUtil);
        int total = goodsCategoryMapper.queryGoodsCategoryCount(pageQueryUtil);
        PageResult pageResult = new PageResult(goodsCategoriesList, total, pageQueryUtil.getLimit(), pageQueryUtil.getPage());
        return pageResult;
    }

    @Override
    public String insertGoodsCategory(GoodsCategory goodsCategory) {
        QueryWrapper<GoodsCategory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("category_name", goodsCategory.getCategoryName());
        queryWrapper.eq("category_level", goodsCategory.getCategoryLevel());
        queryWrapper.eq("is_deleted", 0);
        GoodsCategory goodsCategory1 = goodsCategoryMapper.selectOne(queryWrapper);
        if (goodsCategory1 != null) {
            return ServiceResultEnum.SAME_CATEGORY_EXIST.getResult();
        }
        if (goodsCategoryMapper.insert(goodsCategory) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public String updateGoodsCategory(GoodsCategory goodsCategory) {
        QueryWrapper<GoodsCategory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", goodsCategory.getId());
        queryWrapper.eq("is_deleted", 0);
        GoodsCategory goodsCategory1 = goodsCategoryMapper.selectOne(queryWrapper);
        if (goodsCategory1 == null) {
            return ServiceResultEnum.DATA_NOT_EXIST.getResult();
        }
        queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("category_name", goodsCategory.getCategoryName());
        queryWrapper.eq("category_level", goodsCategory.getCategoryLevel());
        queryWrapper.eq("is_deleted", 0);
        goodsCategory1 = goodsCategoryMapper.selectOne(queryWrapper);
        if (goodsCategory1 != null && !goodsCategory1.getId().equals(goodsCategory.getId())) {
            return ServiceResultEnum.SAME_CATEGORY_EXIST.getResult();
        }
        goodsCategory.setUpdateTime(new Date());
        queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", goodsCategory.getId());
        if (goodsCategoryMapper.update(goodsCategory, queryWrapper) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public List<GoodsCategory> queryShopCategoryLevelByParentId(List<Long> parentIds, int categoryLevel) {
        return goodsCategoryMapper.queryShopCategoryLevelByParentId(parentIds, categoryLevel);
    }

    @Override
    public GoodsCategory queryGoodsCategoryById(Long categoryId) {
        QueryWrapper<GoodsCategory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", categoryId);
        queryWrapper.eq("is_deleted", 0);
        return goodsCategoryMapper.selectOne(queryWrapper);
    }

    @Override
    public Boolean deleteBatch(Integer[] ids) {
        if (ids.length < 1) {
            return false;
        }
        //删除分类数据
        return goodsCategoryMapper.deleteBatch(ids) > 0;
    }


}
