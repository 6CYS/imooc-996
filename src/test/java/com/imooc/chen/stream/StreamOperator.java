package com.imooc.chen.stream;

import com.alibaba.fastjson.JSON;
import com.imooc.chen.lambda.cart.CartService;
import com.imooc.chen.lambda.cart.Sku;
import com.imooc.chen.lambda.cart.SkuCategoryEnum;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * 演示流的各种操作
 */
public class StreamOperator {

    List<Sku> list;

    @Before
    public void init() {
        list = CartService.getCartSkuList();
    }

    /******************** 无状态操作：对每条数据进行操作 ********************/

    @Test
    public void filterTest() {
        list.stream()
                .filter(sku -> SkuCategoryEnum.BOOKS.equals(sku.getSkuCategory()))
                .forEach(item -> System.out.println(JSON.toJSONString(item, true)));
    }

    @Test
    public void mapTest() {
        list.stream()
                .map(Sku::getSkuName)
                .forEach(item -> System.out.println(JSON.toJSONString(item, true)));
    }

    @Test
    public void flatMapTest() {
        list.stream()
                .flatMap(sku -> Arrays.stream(sku.getSkuName().split("")))
                .forEach(item -> System.out.println(JSON.toJSONString(item, true)));
    }

    @Test
    public void peekTest() {
        list.stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .forEach(item -> System.out.println(JSON.toJSONString(item, true)));
    }

    /******************** 有状态操作：基于所有数据进行操作 ********************/

    @Test
    public void sortTest() {
        list.stream()
                .sorted(Comparator.comparing(Sku::getTotalPrice))
                .forEach(item -> System.out.println(JSON.toJSONString(item, true)));
    }

    @Test
    public void distinctTest() {
        list.stream()
                .map(Sku::getSkuCategory)
                .distinct()
                .forEach(item -> System.out.println(JSON.toJSONString(item, true)));
    }

    @Test
    public void skipTest() {
        list.stream()
                .sorted(Comparator.comparing(Sku::getTotalPrice))
                .skip(3)
                .forEach(item -> System.out.println(JSON.toJSONString(item, true)));
    }

    @Test
    public void limitTest() {
        list.stream()
                .sorted(Comparator.comparing(Sku::getTotalPrice))
                .limit(3)
                .forEach(item -> System.out.println(JSON.toJSONString(item, true)));
    }

    /******************** 非短路操作：对每条数据进行操作 ********************/

    @Test
    public void maxTest() {
        OptionalDouble max = list.stream()
                .mapToDouble(Sku::getTotalPrice)
                .max();

        System.out.println(max.getAsDouble());
    }

    @Test
    public void minTest() {
        OptionalDouble min = list.stream()
                .mapToDouble(Sku::getTotalPrice)
                .min();

        System.out.println(min.getAsDouble());
    }

    @Test
    public void countTest() {
        long count = list.stream()
                .count();

        System.out.println(count);
    }


    /******************** 短路操作：仅对部分数据进行操作，操作完成即结束。 ********************/

    @Test
    public void allMatchTest() {
        boolean allMatch = list.stream()
                .peek(sku -> System.out.println(sku.getSkuName() + ", " + sku.getTotalPrice()))
                .allMatch(sku -> sku.getTotalPrice() > 100);

        System.out.println(allMatch);
    }

    @Test
    public void anyMatchTest() {
        boolean allMatch = list.stream()
                .peek(sku -> System.out.println(sku.getSkuName() + ", " + sku.getTotalPrice()))
                .anyMatch(sku -> sku.getTotalPrice() > 100);

        System.out.println(allMatch);
    }

    @Test
    public void noneMatchTest() {
        boolean allMatch = list.stream()
                .peek(sku -> System.out.println(sku.getSkuName() + ", " + sku.getTotalPrice()))
                .noneMatch(sku -> sku.getTotalPrice() > 10000);

        System.out.println(allMatch);
    }

    @Test
    public void findFirstTest() {
        Optional<Sku> op = list.stream()
                .peek(sku -> System.out.println(sku.getSkuName() + ", " + sku.getTotalPrice()))
                .findFirst();

        System.out.println(JSON.toJSONString(op.get(), true));
    }

    @Test
    public void findAnyTest() {
        Optional<Sku> op = list.stream()
                .peek(sku -> System.out.println(sku.getSkuName() + ", " + sku.getTotalPrice()))
                .findAny();

        System.out.println(JSON.toJSONString(op.get(), true));
    }

}
