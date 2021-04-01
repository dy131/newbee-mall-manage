package com.ratel.shop.controller.admin;

import cn.hutool.core.util.StrUtil;
import com.ratel.shop.common.Constants;
import com.ratel.shop.common.ServiceResultEnum;
import com.ratel.shop.common.ShopCategoryLevelEnum;
import com.ratel.shop.entity.GoodsCategory;
import com.ratel.shop.entity.ShopGoods;
import com.ratel.shop.service.ShopCategoryService;
import com.ratel.shop.service.ShopGoodsService;
import com.ratel.shop.util.PageQueryUtil;
import com.ratel.shop.util.Result;
import com.ratel.shop.util.ResultGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
@Slf4j
public class ShopGoodsController {

    @Resource
    private ShopGoodsService shopGoodsService;

    @Resource
    private ShopCategoryService shopCategoryService;

    @GetMapping("/goods")
    public String goodsPage(HttpServletRequest request) {
        request.setAttribute("path", "shop_goods");
        return "admin/shop_goods";
    }

    /**
     * 商品列表
     */
    @RequestMapping(value = "/goods/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(@RequestParam Map<String, Object> params) {
        if (params.get("page") == null || params.get("limit") == null) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        PageQueryUtil pageQueryUtil = new PageQueryUtil(params);
        return ResultGenerator.genSuccessResult(shopGoodsService.queryRatelShopGoodsPageList(pageQueryUtil));
    }

    /**
     * 商品分类查询
     */
    @GetMapping("/goods/edit")
    public String edit(HttpServletRequest request) {
        request.setAttribute("path", "edit");
        // 查询所有的一级分类
        List<GoodsCategory> firstLevelCategories = shopCategoryService.queryShopCategoryLevelByParentId(Collections.singletonList(0L),
                ShopCategoryLevelEnum.LEVEL_ONE.getLevel());
        if (!CollectionUtils.isEmpty(firstLevelCategories)) {
            // 查询一级分类列表中第一个实体的所有二级分类
            List<GoodsCategory> secondLevelCategories = shopCategoryService.queryShopCategoryLevelByParentId(Collections.singletonList(firstLevelCategories.get(0).getId()),
                    ShopCategoryLevelEnum.LEVEL_TWO.getLevel());
            if (!CollectionUtils.isEmpty(secondLevelCategories)) {
                // 查询二级分类列表中第一个实体的所有三级分类
                List<GoodsCategory> thirdLevelCategories = shopCategoryService.queryShopCategoryLevelByParentId(Collections.singletonList(secondLevelCategories.get(0).getId()),
                        ShopCategoryLevelEnum.LEVEL_THREE.getLevel());
                request.setAttribute("firstLevelCategories", firstLevelCategories);
                request.setAttribute("secondLevelCategories", secondLevelCategories);
                request.setAttribute("thirdLevelCategories", thirdLevelCategories);
                request.setAttribute("path", "goods-edit");
                return "admin/shop_goods_edit";
            }
        }
        return "error/error_5xx";
    }

    /**
     * 商品信息新增
     */
    @RequestMapping(value = "/goods/save", method = RequestMethod.POST)
    @ResponseBody
    public Result save(@RequestBody ShopGoods shopGoods) {
        if (StrUtil.isBlank(shopGoods.getGoodsName())
                || StrUtil.isBlank(shopGoods.getGoodsIntro())
                || StrUtil.isBlank(shopGoods.getTag())
                || Objects.isNull(shopGoods.getOriginalPrice())
                || Objects.isNull(shopGoods.getGoodsCategoryId())
                || Objects.isNull(shopGoods.getSellingPrice())
                || Objects.isNull(shopGoods.getStockNum())
                || Objects.isNull(shopGoods.getGoodsSellStatus())
                || StrUtil.isBlank(shopGoods.getGoodsCoverImg())
                || StrUtil.isBlank(shopGoods.getGoodsDetailContent())) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        String result = shopGoodsService.insertRatelShopGoods(shopGoods);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }

    /**
     * 商品信息修改
     */
    @RequestMapping(value = "/goods/update", method = RequestMethod.POST)
    @ResponseBody
    public Result update(@RequestBody ShopGoods shopGoods) {
        if (Objects.isNull(shopGoods.getId())
                || StrUtil.isBlank(shopGoods.getGoodsName())
                || StrUtil.isBlank(shopGoods.getGoodsIntro())
                || StrUtil.isBlank(shopGoods.getTag())
                || Objects.isNull(shopGoods.getOriginalPrice())
                || Objects.isNull(shopGoods.getSellingPrice())
                || Objects.isNull(shopGoods.getGoodsCategoryId())
                || Objects.isNull(shopGoods.getStockNum())
                || Objects.isNull(shopGoods.getGoodsSellStatus())
                || StrUtil.isBlank(shopGoods.getGoodsCoverImg())
                || StrUtil.isBlank(shopGoods.getGoodsDetailContent())) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        String result = shopGoodsService.updateRatelShopGoods(shopGoods);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }

    /**
     * 商品信息详情
     */
    @GetMapping("/goods/edit/{id}")
    public String edit(HttpServletRequest request, @PathVariable("id") Long id) {
        request.setAttribute("path", "edit");
        ShopGoods shopGoods = shopGoodsService.queryRatelShopGoodsById(id);
        if (shopGoods == null) {
            return "error/error_400";
        }
        if (shopGoods.getGoodsCategoryId() > 0) {
            if (shopGoods.getGoodsCategoryId() != null || shopGoods.getGoodsCategoryId() > 0) {
                //有分类字段则查询相关分类数据返回给前端以供分类的三级联动显示
                GoodsCategory currentGoodsCategory = shopCategoryService.queryGoodsCategoryById(shopGoods.getGoodsCategoryId());
                //商品表中存储的分类id字段为三级分类的id，不为三级分类则是错误数据
                if (currentGoodsCategory != null && currentGoodsCategory.getCategoryLevel() == ShopCategoryLevelEnum.LEVEL_THREE.getLevel()) {
                    //查询所有的一级分类
                    List<GoodsCategory> firstLevelCategories = shopCategoryService.queryShopCategoryLevelByParentId(Collections.singletonList(0L), ShopCategoryLevelEnum.LEVEL_ONE.getLevel());
                    //根据parentId查询当前parentId下所有的三级分类
                    List<GoodsCategory> thirdLevelCategories = shopCategoryService.queryShopCategoryLevelByParentId(Collections.singletonList(currentGoodsCategory.getParentId()), ShopCategoryLevelEnum.LEVEL_THREE.getLevel());
                    //查询当前三级分类的父级二级分类
                    GoodsCategory secondCategory = shopCategoryService.queryGoodsCategoryById(currentGoodsCategory.getParentId());
                    if (secondCategory != null) {
                        //根据parentId查询当前parentId下所有的二级分类
                        List<GoodsCategory> secondLevelCategories = shopCategoryService.queryShopCategoryLevelByParentId(Collections.singletonList(secondCategory.getParentId()), ShopCategoryLevelEnum.LEVEL_TWO.getLevel());
                        //查询当前二级分类的父级一级分类
                        GoodsCategory firstCategory = shopCategoryService.queryGoodsCategoryById(secondCategory.getParentId());
                        if (firstCategory != null) {
                            //所有分类数据都得到之后放到request对象中供前端读取
                            request.setAttribute("firstLevelCategories", firstLevelCategories);
                            request.setAttribute("secondLevelCategories", secondLevelCategories);
                            request.setAttribute("thirdLevelCategories", thirdLevelCategories);
                            request.setAttribute("firstLevelCategoryId", firstCategory.getId());
                            request.setAttribute("secondLevelCategoryId", secondCategory.getId());
                            request.setAttribute("thirdLevelCategoryId", currentGoodsCategory.getId());
                        }
                    }
                }
            }
        }
        if (shopGoods.getGoodsCategoryId() == 0) {
            //查询所有的一级分类
            List<GoodsCategory> firstLevelCategories = shopCategoryService.queryShopCategoryLevelByParentId(Collections.singletonList(0L), ShopCategoryLevelEnum.LEVEL_ONE.getLevel());
            if (!CollectionUtils.isEmpty(firstLevelCategories)) {
                //查询一级分类列表中第一个实体的所有二级分类
                List<GoodsCategory> secondLevelCategories = shopCategoryService.queryShopCategoryLevelByParentId(Collections.singletonList(firstLevelCategories.get(0).getId()), ShopCategoryLevelEnum.LEVEL_TWO.getLevel());
                if (!CollectionUtils.isEmpty(secondLevelCategories)) {
                    //查询二级分类列表中第一个实体的所有三级分类
                    List<GoodsCategory> thirdLevelCategories = shopCategoryService.queryShopCategoryLevelByParentId(Collections.singletonList(secondLevelCategories.get(0).getId()), ShopCategoryLevelEnum.LEVEL_THREE.getLevel());
                    request.setAttribute("firstLevelCategories", firstLevelCategories);
                    request.setAttribute("secondLevelCategories", secondLevelCategories);
                    request.setAttribute("thirdLevelCategories", thirdLevelCategories);
                }
            }
        }
        request.setAttribute("goods", shopGoods);
        request.setAttribute("path", "goods-edit");
        return "admin/shop_goods_edit";
    }

    /**
     * 详情
     */
    @GetMapping("/goods/info/{id}")
    @ResponseBody
    public Result info(@PathVariable("id") Long id) {
        ShopGoods goods = shopGoodsService.queryRatelShopGoodsById(id);
        if (goods == null) {
            return ResultGenerator.genFailResult(ServiceResultEnum.DATA_NOT_EXIST.getResult());
        }
        return ResultGenerator.genSuccessResult(goods);
    }

    /**
     * 批量修改销售状态
     */
    @RequestMapping(value = "/goods/status/{sellStatus}", method = RequestMethod.PUT)
    @ResponseBody
    public Result delete(@RequestBody Long[] ids, @PathVariable("sellStatus") int sellStatus) {
        if (ids.length < 1) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        if (sellStatus != Constants.SELL_STATUS_UP && sellStatus != Constants.SELL_STATUS_DOWN) {
            return ResultGenerator.genFailResult("状态异常！");
        }
        if (shopGoodsService.batchUpdateSellStatus(ids, sellStatus)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("修改失败");
        }
    }

}