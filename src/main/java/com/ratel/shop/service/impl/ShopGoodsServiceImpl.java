package com.ratel.shop.service.impl;

import com.ratel.shop.common.ServiceResultEnum;
import com.ratel.shop.entity.ShopGoods;
import com.ratel.shop.mapper.ShopGoodsMapper;
import com.ratel.shop.service.ShopGoodsService;
import com.ratel.shop.util.PageQueryUtil;
import com.ratel.shop.util.PageResult;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ShopGoodsServiceImpl implements ShopGoodsService {

    @Resource
    private ShopGoodsMapper shopGoodsMapper;

    @Override
    public String insertRatelShopGoods(ShopGoods shopGoods) {
        int insert = shopGoodsMapper.insert(shopGoods);
        if (insert > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public PageResult queryRatelShopGoodsPageList(PageQueryUtil pageQueryUtil) {
        List<ShopGoods> goodsList = shopGoodsMapper.queryRatelShopGoodsPageList(pageQueryUtil);
        int total = shopGoodsMapper.getTotalNewBeeMallGoods(pageQueryUtil);
        PageResult pageResult = new PageResult(goodsList, total, pageQueryUtil.getLimit(), pageQueryUtil.getPage());
        return pageResult;
    }










    @Override
    public void batchSaveNewBeeMallGoods(List<ShopGoods> newBeeMallGoodsList) {
        if (!CollectionUtils.isEmpty(newBeeMallGoodsList)) {
            shopGoodsMapper.batchInsert(newBeeMallGoodsList);
        }
    }

    @Override
    public String updateNewBeeMallGoods(ShopGoods goods) {
        ShopGoods temp = shopGoodsMapper.selectByPrimaryKey(goods.getGoodsId());
        if (temp == null) {
            return ServiceResultEnum.DATA_NOT_EXIST.getResult();
        }
        goods.setUpdateTime(new Date());
        if (shopGoodsMapper.updateByPrimaryKeySelective(goods) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public ShopGoods getNewBeeMallGoodsById(Long id) {
        return shopGoodsMapper.selectByPrimaryKey(id);
    }

    @Override
    public Boolean batchUpdateSellStatus(Long[] ids, int sellStatus) {
        return shopGoodsMapper.batchUpdateSellStatus(ids, sellStatus) > 0;
    }
}
