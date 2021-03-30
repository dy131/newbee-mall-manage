package com.ratel.shop.service.impl;

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
    public PageResult getCategorisPage(PageQueryUtil pageUtil) {
        List<GoodsCategory> goodsCategories = goodsCategoryMapper.findGoodsCategoryList(pageUtil);
        int total = goodsCategoryMapper.getTotalGoodsCategories(pageUtil);
        PageResult pageResult = new PageResult(goodsCategories, total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
    }

    @Override
    public String saveCategory(GoodsCategory goodsCategory) {
        GoodsCategory temp = goodsCategoryMapper.selectByLevelAndName(goodsCategory.getCategoryLevel(), goodsCategory.getCategoryName());
        if (temp != null) {
            return ServiceResultEnum.SAME_CATEGORY_EXIST.getResult();
        }
        if (goodsCategoryMapper.insertSelective(goodsCategory) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public String updateGoodsCategory(GoodsCategory goodsCategory) {
        GoodsCategory temp = goodsCategoryMapper.selectByPrimaryKey(goodsCategory.getId());
        if (temp == null) {
            return ServiceResultEnum.DATA_NOT_EXIST.getResult();
        }
        GoodsCategory temp2 = goodsCategoryMapper.selectByLevelAndName(goodsCategory.getCategoryLevel(), goodsCategory.getCategoryName());
        if (temp2 != null && !temp2.getId().equals(goodsCategory.getId())) {
            //同名且不同id 不能继续修改
            return ServiceResultEnum.SAME_CATEGORY_EXIST.getResult();
        }
        goodsCategory.setUpdateTime(new Date());
        if (goodsCategoryMapper.updateByPrimaryKeySelective(goodsCategory) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public GoodsCategory getGoodsCategoryById(Long id) {
        return goodsCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public Boolean deleteBatch(Integer[] ids) {
        if (ids.length < 1) {
            return false;
        }
        //删除分类数据
        return goodsCategoryMapper.deleteBatch(ids) > 0;
    }

    @Override
    public List<GoodsCategory> queryShopCategoryLevelByParentId(List<Long> parentIds, int categoryLevel) {
        return goodsCategoryMapper.queryShopCategoryLevelByParentId(parentIds, categoryLevel);
    }
}
