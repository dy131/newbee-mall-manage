package com.ratel.shop.common;

public class ShopException extends RuntimeException {

    public ShopException() {
    }

    public ShopException(String message) {
        super(message);
    }

    /**
     * 丢出一个异常
     */
    public static void fail(String message) {
        throw new ShopException(message);
    }

}
