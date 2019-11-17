package com.imooc.chen.stream;

import com.alibaba.fastjson.JSON;
import com.imooc.chen.lambda.cart.CartService;
import com.imooc.chen.lambda.cart.Sku;
import com.imooc.chen.lambda.cart.SkuCategoryEnum;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class StreamTest {


    /**
     * 流使用的综合演示
     */

    @Test
    public void cartHandle() {

        AtomicReference<Double> money = new AtomicReference<>(0.0);

        List<String> resultSkuNameList = CartService.getCartSkuList()
                .stream()
                // 打印商品信息
                .peek(sku -> System.out.println(JSON.toJSONString(sku, true)))
                // 过滤掉图书类商品
                .filter(sku -> !SkuCategoryEnum.BOOKS.equals(sku.getSkuCategory()))
                // 排序
                .sorted(Comparator.comparing(Sku::getTotalPrice).reversed())
                // TOP2
                .limit(2)
                // 累加商品金额
                .peek(sku -> money.set(money.get() + sku.getTotalPrice()))
                // 获取商品名称
                .map(Sku::getSkuName)
                // 将各个商品名称合并
                .collect(Collectors.toList());

        System.out.println(JSON.toJSONString(resultSkuNameList, true));
        System.out.println("商品总价：" + money.get());
    }




}
