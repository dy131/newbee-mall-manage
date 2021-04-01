package com.ratel.shop.controller.admin;

import com.ratel.shop.common.ServiceResultEnum;
import com.ratel.shop.entity.ShopOrder;
import com.ratel.shop.entity.ShopOrderItem;
import com.ratel.shop.service.ShopOrderService;
import com.ratel.shop.util.PageQueryUtil;
import com.ratel.shop.util.Result;
import com.ratel.shop.util.ResultGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@Controller
public class ShopOrderController {

    @Resource
    private ShopOrderService shopOrderService;

    @GetMapping("/orders")
    public String ordersPage(HttpServletRequest request) {
        request.setAttribute("path", "orders");
        return "admin/shop_order";
    }

    @RequestMapping(value = "/orders/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(@RequestParam Map<String, Object> params) {
        if (params.get("page") == null || params.get("limit") == null) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        PageQueryUtil pageQueryUtil = new PageQueryUtil(params);
        return ResultGenerator.genSuccessResult(shopOrderService.queryShopOrderPageList(pageQueryUtil));
    }

    @RequestMapping(value = "/orders/update", method = RequestMethod.POST)
    @ResponseBody
    public Result update(@RequestBody ShopOrder shopOrder) {
        if (Objects.isNull(shopOrder.getTotalPrice())
                || Objects.isNull(shopOrder.getOrderId())
                || shopOrder.getOrderId() < 1
                || shopOrder.getTotalPrice().compareTo(BigDecimal.ZERO) < 1) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        String result = shopOrderService.updateShopOrder(shopOrder);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }

    /**
     * 订单详情
     */
    @GetMapping("/order-items/{orderId}")
    @ResponseBody
    public Result info(@PathVariable("orderId") Long orderId) {
        List<ShopOrderItem> orderItems = shopOrderService.queryOrderDetailByOrderId(orderId);
        if (!CollectionUtils.isEmpty(orderItems)) {
            return ResultGenerator.genSuccessResult(orderItems);
        }
        return ResultGenerator.genFailResult(ServiceResultEnum.DATA_NOT_EXIST.getResult());
    }

    /**
     * 配货
     */
    @RequestMapping(value = "/orders/checkDone", method = RequestMethod.POST)
    @ResponseBody
    public Result checkDone(@RequestBody Long[] orderIds) {
        if (orderIds.length < 1) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        String result = shopOrderService.updateOrderAllotStatus(orderIds);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }

    /**
     * 出库
     */
    @RequestMapping(value = "/orders/checkOut", method = RequestMethod.POST)
    @ResponseBody
    public Result checkOut(@RequestBody Long[] orderIds) {
        if (orderIds.length < 1) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        String result = shopOrderService.updateOrderOutStatus(orderIds);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }

    /**
     * 关闭订单
     */
    @RequestMapping(value = "/orders/close", method = RequestMethod.POST)
    @ResponseBody
    public Result closeOrder(@RequestBody Long[] orderIds) {
        if (orderIds.length < 1) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        String result = shopOrderService.updateOrderCloseStatus(orderIds);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }
}