package com.imooc.chen.lambda.file;

import org.junit.Test;

import java.io.IOException;

public class FileServiceTest {

    @Test
    public void fileHandleTest() throws IOException {

        FileService fileService = new FileService();

        fileService.fileHandle("/Users/liuchen/MyDev/imooc/996/src/test/java/com/imooc/chen/lambda/file/FileServiceTest.java"
                , fileContent -> {
                    System.out.println(fileContent);
                });
    }


}
