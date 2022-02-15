package com.xubw.paymentdemo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author XuBowen
 * @version 1.0
 * @date 2022/1/13 17:56
 */

@Data
@TableName("t_product")
public class Product extends BaseEntity{

    private String title;  //商品价格

    private Integer price; //价格（分）
}
