package com.ratel.shop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.ratel.shop"})
@MapperScan("com.ratel.shop.mapper")
public class RatelShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(RatelShopApplication.class, args);
    }

}
