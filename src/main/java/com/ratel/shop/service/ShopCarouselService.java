package com.ratel.shop.service;

import com.ratel.shop.util.PageQueryUtil;
import com.ratel.shop.util.PageResult;
import com.ratel.shop.entity.Carousel;

public interface ShopCarouselService {

    PageResult getCarouselPage(PageQueryUtil pageUtil);

    String saveCarousel(Carousel carousel);

    String updateCarousel(Carousel carousel);

    Carousel getCarouselById(Integer id);

    Boolean deleteBatch(Integer[] ids);
}
