# Fileter

```java
package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) throws Exception {
        byte[] data = "hello.world!".getBytes(StandardCharsets.UTF_8);
        try(CountInputStream input = new CountInputStream(new ByteArrayInputStream(data))){
            int n;
            while((n= input.read())!=-1){
                System.out.println((char) n);
            }
            System.out.println(input.getBytesRead());
        }
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