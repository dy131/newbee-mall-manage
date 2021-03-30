package com.ratel.shop.service;

import com.ratel.shop.util.PageQueryUtil;
import com.ratel.shop.util.PageResult;

public interface ShopUserService {

    PageResult getNewBeeMallUsersPage(PageQueryUtil pageUtil);

    /**
     * 用户禁用与解除禁用(0-未锁定 1-已锁定)
     *
     * @param ids
     * @param lockStatus
     * @return
     */
    Boolean lockUsers(Integer[] ids, int lockStatus);
}
