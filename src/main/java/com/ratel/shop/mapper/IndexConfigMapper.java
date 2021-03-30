package com.ratel.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ratel.shop.entity.IndexConfig;
import com.ratel.shop.util.PageQueryUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IndexConfigMapper extends BaseMapper<IndexConfig> {
    int deleteByPrimaryKey(Long configId);

    int insert(IndexConfig record);

    int insertSelective(IndexConfig record);

    IndexConfig selectByPrimaryKey(Long configId);

    int updateByPrimaryKeySelective(IndexConfig record);

    int updateByPrimaryKey(IndexConfig record);

    List<IndexConfig> findIndexConfigList(PageQueryUtil pageUtil);

    int getTotalIndexConfigs(PageQueryUtil pageUtil);

    int deleteBatch(Long[] ids);

    List<IndexConfig> findIndexConfigsByTypeAndNum(@Param("configType") int configType, @Param("number") int number);
}