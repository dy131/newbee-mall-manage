package com.ratel.shop.service.impl;

import com.ratel.shop.common.ServiceResultEnum;
import com.ratel.shop.entity.ShopCarousel;
import com.ratel.shop.mapper.ShopCarouselMapper;
import com.ratel.shop.service.ShopCarouselService;
import com.ratel.shop.util.PageQueryUtil;
import com.ratel.shop.util.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class ShopCarouselServiceImpl implements ShopCarouselService {

    @Resource
    private ShopCarouselMapper shopCarouselMapper;

    @Override
    public PageResult queryShopCarouselPageList(PageQueryUtil pageQueryUtil) {
        List<ShopCarousel> carousels = shopCarouselMapper.queryShopCarouselPageList(pageQueryUtil);
        int total = shopCarouselMapper.queryShopCarouselPageCount(pageQueryUtil);
        PageResult pageResult = new PageResult(carousels, total, pageQueryUtil.getLimit(), pageQueryUtil.getPage());
        return pageResult;
    }

    @Override
    public String insertCarousel(ShopCarousel carousel) {
        if (shopCarouselMapper.insert(carousel) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public String updateCarousel(ShopCarousel carousel) {
        ShopCarousel carousel1 = shopCarouselMapper.selectById(carousel.getId());
        if (carousel1 == null) {
            return ServiceResultEnum.DATA_NOT_EXIST.getResult();
        }
        carousel1.setCarouselRank(carousel.getCarouselRank());
        carousel1.setRedirectUrl(carousel.getRedirectUrl());
        carousel1.setCarouselUrl(carousel.getCarouselUrl());
        carousel1.setUpdateTime(new Date());
        if (shopCarouselMapper.updateById(carousel1) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public ShopCarousel queryCarouselById(Long id) {
        return shopCarouselMapper.selectById(id);
    }

    @Override
    public Boolean deleteBatchCarouse(Long[] ids) {
        if (ids.length < 1) {
            return false;
        }
        return shopCarouselMapper.deleteBatchIds(Arrays.asList(ids)) > 0;
    }
}
