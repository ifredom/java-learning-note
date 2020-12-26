# Map

> Map 是一种键值对（Key-Value）映射表的数据格式，他是无序的，能够高效的通过Key值找到Value值
> Map 是一个集合接口，常用的集合为HashMap集合、LinkedHashMap集合


## Map遍历的四种方式

```java
package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Map<String, Integer> map = new HashMap<>();
        map.put("apple",14);
        map.put("banana",8);

        // 遍历方式一. maps.entrySet
        for (Map.Entry<String,Integer> entry :map.entrySet()){
            System.out.println(entry);
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        // 遍历方式二. 仅单独需要使用Key或Value时使用，效率较高
        for (String key:map.keySet()){
            System.out.println(key);
        }
        for (Integer value:map.values()){
            System.out.println(value);
        }

        // 遍历方式三. 通过Iterator
        for (Iterator<Map.Entry<String,Integer>> entries = map.entrySet().iterator(); entries.hasNext();){
            Map.Entry<String,Integer> entry = entries.next();
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        // 遍历方式三. 直接通过键值去查找，效率低
        for (String key: map.keySet()){
            System.out.println(map.get(key));
        }
    }
}

```

## `HashMap<K,V>` & `LinkedHashMap<K,V>`

* `HashMap<K,V>`：存储数据采用的哈希表结构，元素的存取顺序不能保证一致。由于要保证键的唯一、不重复，需要重写键的hashCode()方法、equals()方法。

* `LinkedHashMap<K,V>`：HashMap下有个子类LinkedHashMap，存储数据采用的哈希表结构+链表结构。通过链表结构可以保证元素的存取顺序一致；通过哈希表结构可以保证的键的唯一、不重复，需要重写键的hashCode()方法、equals()方法。

注意：Map接口中的集合都有两个泛型变量<K,V>,在使用时，要为两个泛型变量赋予数据类型。两个泛型变量<K,V>的数据类型可以相同，也可以不同。


## 练习题

> 编写一个根据name查找score的程序，并利用Map充当缓存，以提高查找效率
```java
package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        List<Student> list = List.of(
                new Student("Bob", 78),
                new Student("Alice", 85),
                new Student("Brush", 66),
                new Student("Newton", 99));
        Students holder = new Students(list);
        System.out.println(holder.getScore("Bob") == 78 ? "测试成功!" : "测试失败!");
        System.out.println(holder.getScore("Alice") == 85 ? "测试成功!" : "测试失败!");
        System.out.println(holder.getScore("Tom") == -1 ? "测试成功!" : "测试失败!");
    }
}

class Students{
    List<Student> list;
    Map<String,Integer> cache;

    Students(List<Student> list){
        this.list = list;
        cache = new HashMap<>();
    }

    int getScore(String name){
        Integer score = this.cache.get(name);
        if(score==null){
            score = this.findInList(name);
            System.out.println(score);
            if(score!=null){
                this.cache.put(name,score);
            }
        }
        return score==null?-1:score.intValue();
    }

    Integer findInList(String name){
        for (Student item:this.list){
            if(item.name.equals(name)){
                return item.score;
            }
        }
        return null;
    }
}

class Student{
    String name;
    int score;

    Student(String name, int score){
        this.name = name;
        this.score = score;
    }
}
```