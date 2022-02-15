package com.xubw.paymentdemo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author XuBowen
 * @version 1.0
 * @date 2022/1/13 17:47
 */

@Data
@TableName("t_order_info")
public class OrderInfo extends BaseEntity{

    private String title;       //订单标题

    private String orderNo;     //商品订单编号

    private Long userId;        //用户Id

    private Long productId;     //支付产品Id

    private Integer totalFee;   //订单金额（分）

    private String codeUrl;     //订单二维码链接

    private String orderStatus; //订单状态
}
