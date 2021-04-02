package com.ratel.shop.service;

import com.ratel.shop.util.PageQueryUtil;
import com.ratel.shop.util.PageResult;
import com.ratel.shop.entity.ShopCarousel;

public interface ShopCarouselService {

    PageResult queryShopCarouselPageList(PageQueryUtil pageQueryUtil);

    String insertCarousel(ShopCarousel carousel);

    String updateCarousel(ShopCarousel carousel);

    ShopCarousel queryCarouselById(Long id);

    Boolean deleteBatchCarouse(Long[] ids);
}
