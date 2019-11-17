package com.imooc.chen.lambda.cart;

public enum SkuCategoryEnum {
    // 服装类
    CLOTHING(10, "服装类"),
    // 数码类
    ELECTRONICS(20, "数码类"),
    // 运动类
    SPORTS(30, "运动类"),
    // 图书类
    BOOKS(40, "图书类");


    // 商品类型编号
    private Integer code;

    //商品类型名称
    private String name;

    SkuCategoryEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
}
