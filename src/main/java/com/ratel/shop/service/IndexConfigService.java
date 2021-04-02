package com.ratel.shop.service;

import com.ratel.shop.util.PageQueryUtil;
import com.ratel.shop.util.PageResult;
import com.ratel.shop.entity.IndexConfig;

public interface IndexConfigService {

    PageResult queryConfigsPageList(PageQueryUtil pageQueryUtil);

    String insertIndexConfig(IndexConfig indexConfig);

    String updateIndexConfig(IndexConfig indexConfig);

    Boolean deleteIndexConfigBatch(Long[] ids);
}
