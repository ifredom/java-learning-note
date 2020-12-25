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

        ArrayList<String> testList1 = new ArrayList<String>(){{add("apple");add("pear");add("banana");add(null);}};
        System.out.println(testList1);

        List<String> testListX = new ArrayList<String>(list2);

        testListX.add("orange");
        System.out.println(testListX);


    }
}
