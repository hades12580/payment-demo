package com.xubw.paymentdemo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author XuBowen
 * @version 1.0
 * @date 2022/1/13 18:07
 */

@Configuration
@MapperScan("com.xubw.paymentdemo.mapper")
@EnableTransactionManagement //启用事务管理
public class MyBatisPlusConfig {
}
