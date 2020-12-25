# StringBuilder
> Java编译器对String做了特殊处理，使得我们可以直接用+拼接字符串。
> 
> 虽然可以直接拼接字符串，但是，在循环中，每次循环都会创建新的字符串对象，然后扔掉旧的字符串。这样，绝大部分字符串都是临时对象，不但浪费内存，还会影响GC效率。
>为了能高效拼接字符串，Java标准库提供了StringBuilder，它是一个可变对象，可以预分配缓冲区，这样，往StringBuilder中新增字符时，不会创建新的临时对象
```java

package com.company;

import com.xyz.Hello;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        String[] fields = { "name", "position", "salary" };
        String table = "employee";
        String insert = buildInsertSql(table, fields);
        System.out.println(insert);
        String s = "INSERT INTO employee (name, position, salary) VALUES (?, ?, ?)";
        System.out.println(s.equals(insert) ? "测试成功" : "测试失败");

    }
    static String buildInsertSql(String table, String[] fields) {
        // TODO:
        StringBuilder sb = new StringBuilder(1024);
        sb.append(("INSERT INTO "));
        sb.append(table);
        sb.append(" (");


        for (int i = 0; i < fields.length; i++) {
            sb.append(fields[i]);
            if(i== fields.length-1){

            }else{
                sb.append(", ");
            }
        }
        sb.append(")");
        sb.append(" VALUES (?, ?, ?)");
        return sb.toString();
    }
}


```

## 链式操作

> 链式操作的关键是，定义的append()方法会返回this，这样，就可以不断调用自身的其他方法