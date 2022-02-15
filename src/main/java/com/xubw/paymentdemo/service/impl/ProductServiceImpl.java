package com.xubw.paymentdemo.service.impl;

import com.xubw.paymentdemo.entity.Product;
import com.xubw.paymentdemo.mapper.ProductMapper;
import com.xubw.paymentdemo.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author XuBowen
 * @version 1.0
 * @date 2022/1/13 18:04
 */

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

}
