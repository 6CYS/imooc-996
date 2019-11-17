package com.imooc.chen.lambda.methodref;


import org.junit.Test;

import java.util.function.Consumer;

public class MethodRefTest {

    @Test
    public void MethodRefTest1() {
        Consumer<String> consumer1 = (String number) -> System.out.println(number);
        Consumer<String> consumer2 = System.out::println;
        String number = "100";
        consumer1.accept(number);
        consumer2.accept(number);
    }

    @Test
    public void MethodRefTest2() {
        Consumer<String> consumer1 = (String str) -> str.length();
        Consumer<String> consumer2 = String::length;

        String str = "Hello world";
        consumer1.accept(str);
        consumer2.accept(str);
    }

    @Test
    public void MethodRefTest3() {
        StringBuilder stringBuilder = new StringBuilder();

        Consumer<String> consumer1 = (String str) -> stringBuilder.append(str);
        Consumer<String> consumer2 = stringBuilder::append;

        consumer1.accept("append1");
        consumer2.accept("append2");

        System.out.println(stringBuilder);
    }

}
