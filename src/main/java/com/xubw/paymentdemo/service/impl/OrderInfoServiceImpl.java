package com.xubw.paymentdemo.service.impl;

import com.xubw.paymentdemo.entity.OrderInfo;
import com.xubw.paymentdemo.mapper.OrderInfoMapper;
import com.xubw.paymentdemo.service.OrderInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author XuBowen
 * @version 1.0
 * @date 2022/1/13 18:03
 */

@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements OrderInfoService {

}
