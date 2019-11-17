package com.imooc.chen.lambda.file;

@FunctionalInterface
public interface FileConsumer {
    /**
     * 函数式接口抽象方法
     *
     * @param fileContent：文件内容字符串
     */
    void fileHandle(String fileContent);
}
