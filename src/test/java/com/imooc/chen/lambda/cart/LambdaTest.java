package com.imooc.chen.lambda.cart;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.List;

public class LambdaTest {

    @Test
    public void filterElectronicsSkus() {
        List<Sku> carSkuList = CartService.getCartSkuList();

        List<Sku> result = CartService.filterElectronicsSkus(carSkuList);

        System.out.println(JSON.toJSONString(result, true));
    }

    /**
     * 谓词接口类实现方式
     */
    @Test
    public void filterSkusPredicate() {
        List<Sku> carSkuList = CartService.getCartSkuList();

        // 过滤商品总价大于2000的商品
        List<Sku> result = CartService.filterSkus(carSkuList, new SkuTotalPricePredicate());

        System.out.println(JSON.toJSONString(result, true));
    }

    /**
     * 匿名类实现方式
     */
    @Test
    public void filterSkusAnonymousClass() {
        List<Sku> carSkuList = CartService.getCartSkuList();

        // 过滤商品总价大于2000的商品
        List<Sku> result = CartService.filterSkus(carSkuList, new SkuPredicate() {
            @Override
            public boolean test(Sku sku) {
                return sku.getSkuPrice() > 1000;
            }
        });

        System.out.println(JSON.toJSONString(result, true));
    }

    /**
     * Lambda实现方式
     */
    @Test
    public void filterSkusLambda() {
        List<Sku> carSkuList = CartService.getCartSkuList();

        // 过滤商品总价大于2000的商品
        List<Sku> result = CartService.filterSkus(carSkuList, (Sku sku) -> sku.getSkuPrice() > 1000);

        System.out.println(JSON.toJSONString(result, true));
    }


}
