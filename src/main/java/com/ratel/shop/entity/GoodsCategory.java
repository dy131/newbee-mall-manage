package com.ratel.shop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 商品类别
 */
@Data
@Builder
@TableName("t_goods_category")
@NoArgsConstructor
@AllArgsConstructor
public class GoodsCategory extends BaseEntity {

    // 商品分类ID
    private Long categoryId;
    // 分类等级
    private Integer categoryLevel;
    // 父ID
    private Long parentId;
    // 分类名
    private String categoryName;
    // 分类层级
    private Integer categoryRank;
    // 是否删除
    private Integer isDeleted;

    private Integer createUser;

    private Integer updateUser;
}