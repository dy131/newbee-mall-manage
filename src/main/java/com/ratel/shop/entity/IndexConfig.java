package com.ratel.shop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@Builder
@TableName("t_index_config")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class IndexConfig extends BaseEntity {

    private String configName;

    private Integer configType;

    private Long goodsId;

    private String redirectUrl;

    private Integer configRank;

    private Integer isDeleted;
}