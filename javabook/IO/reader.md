# Reader

> Reader是JAVA库提供的一个IO输入流接口。与InputStream的相比较，InputeStream
> 是一个字节流，即一Byte[]为单位进行读取。Reader是一个字符流，以char为单位读取

> Reader本质上是一个基于InputStream的byte到char的转换器
> InputStreamReader就是这样一个转换器，它可以把任何InputStream转换为Reader

## Reader与InputStreamReader

> Reader 内部持有一个InputStreamReader
> Reader 需要从InputStream中读取字节流，
> 然后经过编码设置，再转换为char就可以实现字符流
> 
>
```java
package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        InputStream inputStream = new FileInputStream("./file.txt");
        Reader  reader =  new InputStreamReader(inputStream);
    }
}

```
