package com.xubw.paymentdemo.service.impl;

import com.google.gson.Gson;
import com.xubw.paymentdemo.config.WxPayConfig;
import com.xubw.paymentdemo.entity.OrderInfo;
import com.xubw.paymentdemo.enums.OrderStatus;
import com.xubw.paymentdemo.enums.wxpay.WxApiType;
import com.xubw.paymentdemo.enums.wxpay.WxNotifyType;
import com.xubw.paymentdemo.service.WxPayService;
import com.xubw.paymentdemo.util.OrderNoUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author XuBowen
 * @version 1.0
 * @date 2022/1/14 19:43
 */

@Service
@Slf4j
public class WxPayServiceImpl implements WxPayService {

    @Resource
    private WxPayConfig wxPayConfig;

    @Resource
    private CloseableHttpClient wxPayClient;

    /**
     * 创建订单，调用Native支付接口
     * @param productId
     * @return code_url 和 订单号
     * @throws Exception
     */

    @Override
    public Map<String, Object> nativePay(Long productId) throws Exception {

        log.info("生成订单");

        //生成订单
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setTitle("test");
        orderInfo.setOrderNo(OrderNoUtils.getOrderNo()); //订单号
        orderInfo.setProductId(productId);
        orderInfo.setTotalFee(1); //单位：分
        orderInfo.setOrderStatus(OrderStatus.NOTPAY.getType());
        //TODO：存入数据库

        log.info("调用统一下单API");

        //调用统一下单API
        HttpPost httpPost = new HttpPost(wxPayConfig.getDomain().concat(WxApiType.NATIVE_PAY.getType()));
        // 请求body参数
        Gson gson = new Gson();
        Map paramsMap = new HashMap();
        paramsMap.put("appid", wxPayConfig.getAppid());
        paramsMap.put("mchid", wxPayConfig.getMchId());
        paramsMap.put("description", orderInfo.getTitle());
        paramsMap.put("out_trade_no", orderInfo.getOrderNo());
        paramsMap.put("notify_url", wxPayConfig.getNotifyDomain().concat(WxNotifyType.NATIVE_NOTIFY.getType()));

        Map amountMap = new HashMap();
        amountMap.put("total", orderInfo.getTotalFee());
        amountMap.put("currency", "CNY");

        paramsMap.put("amount", amountMap);

        //将参数转化成字符串
        String jsonParams = gson.toJson(paramsMap);
        log.info("请求参数，" + jsonParams);

        StringEntity entity = new StringEntity(jsonParams,"utf-8");
        entity.setContentType("application/json");
        httpPost.setEntity(entity);
        httpPost.setHeader("Accept", "application/json");

        //完成签名并执行请求
        CloseableHttpResponse response = wxPayClient.execute(httpPost);

        try {
            String bodyAsString = EntityUtils.toString(response.getEntity());
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) { //处理成功
                log.info("成功，返回结果 = " + bodyAsString);
            } else if (statusCode == 204) { //处理成功，无返回Body
                log.info("成功");
            } else {
                log.info("Native下单失败，响应码 = " + statusCode+ ",返回结果 = " + bodyAsString);
                throw new IOException("request failed");
            }

            //响应结果
            HashMap<String, String> resultMap = gson.fromJson(bodyAsString, HashMap.class);
            //二维码
            String  codeUrl = resultMap.get("code_url");

            Map<String, Object> map = new HashMap<>();
            map.put("codeUrl", codeUrl);
            map.put("orderNo", orderInfo.getOrderNo());

            return map;

        } finally {
            response.close();
        }
    }
}
