package com.ratel.shop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@TableName("t_index_config")
public class IndexConfig extends BaseEntity {

    private String configName;

    private Byte configType;

    private Long goodsId;

    private String redirectUrl;

    private Integer configRank;

    private Byte isDeleted;
}