# serializable

> 序列化就是将一个Java对象转换成二进制对象，本质就是byte[]数组。
> 以便于存储于文件中或者通过网络进行远程传播。
```java
package com.company;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try (ObjectOutputStream output = new ObjectOutputStream(buffer)){
            output.writeInt(123);
            output.writeUTF("Hello");
            output.writeObject(Double.valueOf(123.456));

        }
        System.out.println(Arrays.toString(buffer.toByteArray()));
    }
}

class CountInputStream extends FilterInputStream{
     private  int count = 0;


     CountInputStream(InputStream in) {
        super(in);
     }

     public int getBytesRead(){
         return this.count;
     }

     public int read() throws  IOException {

         int n = in.read();
         if (n != -1) {
             this.count ++;
         }
         return n;
     }



     public int read(byte[] bt, int off, int len) throws  IOException {
         int n = in.read(bt, off, len);
         while (n != -1) {
             this.count+=n;
         }
         return n;
     }
}


```