package com.imooc.chen.lambda.file;

import java.io.*;

/**
 * 函数式接口实现的演示
 * 文件服务类。
 */
public class FileService {

    public void fileHandle(String url, FileConsumer fileConsumer) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(url)));

        String line;
        StringBuilder stringBuilder = new StringBuilder();

        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line + "\n");
        }

        fileConsumer.fileHandle(stringBuilder.toString());

    }
}
