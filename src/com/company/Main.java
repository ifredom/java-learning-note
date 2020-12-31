package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) throws Exception {
        String str ;
        InputStream input = new FileInputStream(".\\file.txt");
        str  = readAsString(input);
        System.out.println(str);
        input.close(); // 关闭输入流

        File file = new File(".\\copy.txt");
        String fileName = file.getName();
        System.out.println(fileName);
        if (file.createNewFile()) {
            // 文件创建成功:
        }

        OutputStream output = new FileOutputStream(".\\copy.txt");
        output.write(str.getBytes(StandardCharsets.UTF_8));
        output.close(); // 关闭输出流
    }


    public static String readAsString(InputStream input) throws IOException{
        String str ;
        int n;
        StringBuilder sb = new StringBuilder();
        while ((n=input.read())!=-1){
            sb.append((char) n);
        }
        str = sb.toString();
        return str;
    }
}

