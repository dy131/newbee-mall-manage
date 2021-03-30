package com.ratel.shop.service;

import com.ratel.shop.util.PageQueryUtil;
import com.ratel.shop.util.PageResult;
import com.ratel.shop.entity.IndexConfig;

public interface IndexConfigService {

    PageResult getConfigsPage(PageQueryUtil pageUtil);

    String saveIndexConfig(IndexConfig indexConfig);

    String updateIndexConfig(IndexConfig indexConfig);

    IndexConfig getIndexConfigById(Long id);

    Boolean deleteBatch(Long[] ids);
}
