# InputStream
> InputStream 是Java标准库提供的一个最基本的输入流，它位于java.io包中。
> 需要注意InputStream 并不是一个接口，他是一个抽象类，是所有的输入流的超类。
> 它定义的最重要的方法就是 `int read()`

```java
public abstract int read() throws IOException;
```

> 这个方法会读取输入流的下一个字节，并返回字节表示的int值（0~255）。
> 如果已读到末尾，返回-1表示不能继续读取了

## fileInputStream

> FileInputStream 是 InputStream 的一个子类。顾名思义，FileInputStream就是从文件流中读取数据

##  读取文件示例

> 注意需要在项目根目录下提前创建文件`file.txt`

```java
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


```

