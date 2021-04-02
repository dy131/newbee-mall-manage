/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本软件已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2020 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package com.ratel.shop.service.impl;

import com.ratel.shop.common.ServiceResultEnum;
import com.ratel.shop.entity.IndexConfig;
import com.ratel.shop.mapper.IndexConfigMapper;
import com.ratel.shop.service.IndexConfigService;
import com.ratel.shop.util.PageQueryUtil;
import com.ratel.shop.util.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class IndexConfigServiceImpl implements IndexConfigService {

    @Resource
    private IndexConfigMapper indexConfigMapper;

    @Override
    public PageResult queryConfigsPageList(PageQueryUtil pageQueryUtil) {
        List<IndexConfig> indexConfigs = indexConfigMapper.queryIndexConfigPageList(pageQueryUtil);
        int total = indexConfigMapper.queryIndexConfigPageCount(pageQueryUtil);
        PageResult pageResult = new PageResult(indexConfigs, total, pageQueryUtil.getLimit(), pageQueryUtil.getPage());
        return pageResult;
    }

    @Override
    public String insertIndexConfig(IndexConfig indexConfig) {
        if (indexConfigMapper.insert(indexConfig) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public String updateIndexConfig(IndexConfig indexConfig) {
        IndexConfig indexConfig1 = indexConfigMapper.selectById(indexConfig.getId());
        if (indexConfig1 == null) {
            return ServiceResultEnum.DATA_NOT_EXIST.getResult();
        }
        if (indexConfigMapper.updateById(indexConfig) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public Boolean deleteIndexConfigBatch(Long[] ids) {
        if (ids.length < 1) {
            return false;
        }
        return indexConfigMapper.deleteBatchIds(Arrays.asList(ids)) > 0;
    }
}
