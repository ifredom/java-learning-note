package com.company;

import com.xyz.Hello;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        byte[] b2 = "Hello".getBytes("UTF-8"); // 按UTF-8编码转换
        System.out.println(b2);

    }

    public  static void person(String name,int age){
        String[] arr = {"1","2","3","4"};
        List list = Arrays.asList(arr);
        Collections.swap(list, 0, 3);
        for (String i:arr) {
            System.out.println(i);
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(list.size());
        System.out.println(list);
    }

    public static void ioTest() {
        try {
            byte bWrite[] = { 11, 21, 3, 40, 5 };
            OutputStream os = new FileOutputStream("test.txt");
            for (int x = 0; x < bWrite.length; x++) {
                os.write(bWrite[x]); // writes the bytes
            }
            os.close();

            InputStream is = new FileInputStream("test.txt");
            int size = is.available();

            for (int i = 0; i < size; i++) {
                System.out.print((char) is.read() + "  ");
            }
            is.close();
        } catch (IOException e) {
            System.out.print("Exception");
        }
    }
}

class Person{
    public  Person(){
        count++;
    }
    public static int count = 0;

    public static int getCount() {
        return count;
    }
}