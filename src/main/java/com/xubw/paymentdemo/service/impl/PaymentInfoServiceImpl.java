package com.xubw.paymentdemo.service.impl;

import com.xubw.paymentdemo.entity.PaymentInfo;
import com.xubw.paymentdemo.mapper.PaymentInfoMapper;
import com.xubw.paymentdemo.service.PaymentInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author XuBowen
 * @version 1.0
 * @date 2022/1/13 18:04
 */

@Service
public class PaymentInfoServiceImpl extends ServiceImpl<PaymentInfoMapper, PaymentInfo> implements PaymentInfoService {

}
