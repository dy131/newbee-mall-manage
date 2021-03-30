/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本软件已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2020 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package com.ratel.shop.service;

import com.ratel.shop.entity.ShopGoods;
import com.ratel.shop.util.PageQueryUtil;
import com.ratel.shop.util.PageResult;

import java.util.List;

public interface ShopGoodsService {

    PageResult queryRatelShopGoodsPageList(PageQueryUtil pageQueryUtil);

    String insertRatelShopGoods(ShopGoods shopGoods);

    /**
     * 批量新增商品数据
     *
     * @param newBeeMallGoodsList
     * @return
     */
    void batchSaveNewBeeMallGoods(List<ShopGoods> newBeeMallGoodsList);

    /**
     * 修改商品信息
     *
     * @param goods
     * @return
     */
    String updateNewBeeMallGoods(ShopGoods goods);

    /**
     * 获取商品详情
     *
     * @param id
     * @return
     */
    ShopGoods getNewBeeMallGoodsById(Long id);

    /**
     * 批量修改销售状态(上架下架)
     *
     * @param ids
     * @return
     */
    Boolean batchUpdateSellStatus(Long[] ids, int sellStatus);

}
