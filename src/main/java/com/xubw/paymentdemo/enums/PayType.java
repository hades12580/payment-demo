package com.xubw.paymentdemo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author XuBowen
 * @version 1.0
 * @date 2022/1/14 17:52
 */

@AllArgsConstructor
@Getter
public enum PayType {
    /**
     * 微信
     */
    WXPAY("微信"),


    /**
     * 支付宝
     */
    ALIPAY("支付宝");

    /**
     * 类型
     */
    private final String type;
}
