# List

> list是一种有序列表集合，它是一个接口。

## ArrayList与List的关系

> ArrayList也是一种有序列表集合，他的增删改查都是依据集合中的元素位置而定，比如删除某一个元素，
> 则需要移动相应元素位置，以及受影响的相关元素
> 
> List则是将ArrayList对内部元素的增删改查进行封装，而不用去关心元素位置如何去移动
> 
> 因为List是一个接口，所以实现List的方式不光有ArrayList还有LinkedList（基本不再使用）
> 


## List的初始化

> List的初始化，其实就是对ArrayList的初始化进行封装的过程。
> 所以需要清楚`ArrayList都有哪几种初始化方式`

```java
package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws Exception {
        // 初始化方式一，通用，不简洁
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("pear");
        list.add("banana");
        list.add(null);

        // 初始化方式二,双括号{{}}内部匿名函数
        // 外层的 {} 定义了一个 ArrayList 的匿名内部类。内层的 {} 的定义了一个实例初始化代码块, 代码块在初始化内部类时执行
        List<String> list1 = new ArrayList<String>(){{add("apple");add("pear");add("banana");add(null);}};

        // 初始化方式三，借助Arrays工具类, 常用
        // Arrays.asList 返回的是 Arrays 的静态内部类（静态内部类不持有所在外部类的引用）
        // Arrays.asList 的参数如果是基本类型的数组时，需要留意返回值可能和你预期的不同。
        // 限制：asList是Arrays的静态方法。这种方式构造除的List是固定长度，不能增删
        List<String> list2 = Arrays.asList("apple", "pear", "banana");

        // 初始化方式四，JAVA_JDK_VERSION 11新特性，推介/好用
        // 限制：初始化的元素值不能为null
        List<String> list3 = List.of("apple", "pear", "banana");

        // 初始化方式五，借助Stream
        List<String> list4 = Stream.of("apple", "pear", "banana").collect(Collectors.toList());

        for (Iterator<String> it= list.iterator();it.hasNext();){
            String s = it.next();
            System.out.println(s);
        }

        System.out.println(list1);


    }
}


```

### ArrayList几种初始化方式
* 1. ArrayList<Type> obj = new ArrayList<Type>(Arrays.asList(Object o1, Object o2, Object o3, ....so on));
* 2. 
```java
ArrayList<T> obj = new ArrayList<T>() {{
add(Object o1);
add(Object o2);
...
...
}};
```
* 3.
```java
ArrayList<T> obj = new ArrayList<T>();
obj.add("o1");
obj.add("o2");
// 或者
ArrayList<T> obj = new ArrayList<T>();
List list = Arrays.asList("o1","o2",...);
obj.addAll(list);
```

> 示例
```java
package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        ArrayList arrayList = new ArrayList();
        List<String> list = Arrays.asList("apple", "pear", "banana");
        arrayList.addAll(list);
        for (Iterator<String> it= list.iterator();it.hasNext();){
            String s = it.next();
            System.out.println(s);
        }
        // 使用ArrayList包装一下，上面方法初始化的list就可以改变长度了
        List<String> testListX = new ArrayList<String>(list);
        testListX.add("orange");
        System.out.println(testListX);

    }
}

```
