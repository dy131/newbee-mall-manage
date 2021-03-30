package com.ratel.shop.common;

/**
 * 商品分类级别
 */
public enum ShopCategoryLevelEnum {

    DEFAULT(0, "顶级"),
    LEVEL_ONE(1, "一级分类"),
    LEVEL_TWO(2, "二级分类"),
    LEVEL_THREE(3, "三级分类");

    private int level;

    private String name;

    ShopCategoryLevelEnum(int level, String name) {
        this.level = level;
        this.name = name;
    }

    public static ShopCategoryLevelEnum getShopCategoryEnumByLevel(int level) {
        for (ShopCategoryLevelEnum newBeeMallCategoryLevelEnum : ShopCategoryLevelEnum.values()) {
            if (newBeeMallCategoryLevelEnum.getLevel() == level) {
                return newBeeMallCategoryLevelEnum;
            }
        }
        return DEFAULT;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
