package com.xubw.paymentdemo.service;

import java.io.IOException;
import java.util.Map;

/**
 * @author XuBowen
 * @version 1.0
 * @date 2022/1/14 19:43
 */
public interface WxPayService {
    Map<String, Object> nativePay(Long productId) throws Exception;
}
