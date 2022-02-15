package com.xubw.paymentdemo.controller;

import com.xubw.paymentdemo.entity.Product;
import com.xubw.paymentdemo.service.ProductService;
import com.xubw.paymentdemo.valueObject.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author XuBowen
 * @version 1.0
 * @date 2022/1/13 10:39
 */

@CrossOrigin //开放前段的跨域访问
@Api(tags = "商品管理")
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Resource
    private ProductService productService;

    @ApiOperation("测试接口")
    @GetMapping("/test")
    public R test(){

        return R.ok().data("message", "hello").data("now", new Date());
    }

    @GetMapping("/list")
    public R list(){

        List<Product> list = productService.list();
        return R.ok().data("productList", list);
    }
}
