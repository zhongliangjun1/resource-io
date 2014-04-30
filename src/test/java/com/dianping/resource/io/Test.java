package com.dianping.resource.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-4-30
 * Time: PM4:50
 * To change this template use File | Settings | File Templates.
 */
public class Test {

    public static void loadFromJar() throws IOException {
        ClassPathResource loader = new ClassPathResource("org/springframework/core/io/ClassPathResource.class", Test.class.getClassLoader());
        InputStream inputStream = loader.getInputStream();

        String s = inputStreamToString(inputStream);

        System.out.println("loadFromJar");
    }

    private static String inputStreamToString(InputStream inputStream) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        int BUFFER_SIZE = 1024;
        byte[] data = new byte[BUFFER_SIZE];
        int count = -1;
        while((count = inputStream.read(data,0,BUFFER_SIZE)) != -1)
            outputStream.write(data, 0, count);

        String str = new String(outputStream.toByteArray(),"UTF-8");
        inputStream.close();
        outputStream.close();
        return str;
    }

    public static void main(String[] args) throws Exception{
        loadFromJar();
    }

}
