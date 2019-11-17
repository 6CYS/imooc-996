package com.imooc.chen.stream;

import com.alibaba.fastjson.JSON;
import com.imooc.chen.lambda.cart.CartService;
import com.imooc.chen.lambda.cart.Sku;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamCollector {

    @Test
    public void toList() {
        List<Sku> cartSkuList = CartService.getCartSkuList();

        List<Sku> collect = cartSkuList.stream()
                .filter(sku -> sku.getTotalPrice() > 100)
                .collect(Collectors.toList());

        System.out.println(JSON.toJSONString(collect, true));
    }

    @Test
    public void group() {
        List<Sku> cartSkuList = CartService.getCartSkuList();

        Map<Enum, List<Sku>> collect = cartSkuList.stream()
                .collect(Collectors.groupingBy(
                        Sku::getSkuCategory
                ));

        System.out.println(JSON.toJSONString(collect, true));
    }

    @Test
    public void partition() {
        List<Sku> cartSkuList = CartService.getCartSkuList();

        Map<Boolean, List<Sku>> collect = cartSkuList.stream()
                .collect(Collectors.partitioningBy(
                        sku -> sku.getTotalPrice() > 100
                ));

        System.out.println(JSON.toJSONString(collect, true));
    }
}
