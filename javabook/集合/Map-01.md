# hashMap为什么快

> HashMap之所以能根据key直接拿到value，原因是它内部通过空间换时间的方法，用一个大数组存储所有value，并根据key直接计算出value应该存储在哪个索引

```java
Map<String, Person> map = new HashMap<>();
map.put("a", new Person("Xiao Ming"));
map.put("b", new Person("Xiao Hong"));
map.put("c", new Person("Xiao Jun"));

map.get("a"); // Person("Xiao Ming")
map.get("x"); // null
```

## Map使用注意事项

> 在Map的内部，对key做比较是通过equals()实现的，这一点和List查找元素需要
> 正确覆写equals()是一样的，即正确使用Map必须保证：作为key的对象必须正确覆写equals()方法。

> 我们经常使用String作为key，因为String已经正确覆写了equals()方法。
> 但如果我们放入的key是一个自己写的类，就必须保证正确覆写了equals()方法。
>
* 为key的对象必须正确覆写equals()方法，相等的两个key实例调用equals()必须返回true；
* 作为key的对象还必须正确覆写hashCode()方法，且hashCode()方法要严格遵循以下规范：

* - 如果两个对象相等，则两个对象的hashCode()必须相等；
* - 如果两个对象不相等，则两个对象的hashCode()尽量不要相等。

## EnumMap


如果Key的类型是Enum。那么使用EnumMap

## TreeMap

> 使用TreeMap时，放入的Key必须实现Comparable接口。String、Integer这些类已经实现了
> Comparable接口，因此可以直接作为Key使用。作为Value的对象则没有任何要求。
> 
> SortedMap在遍历时严格按照Key的顺序遍历，最常用的实现类是TreeMap；
> 作为SortedMap的Key必须实现Comparable接口，或者传入Comparator；
> 要严格按照compare()规范实现比较逻辑，否则，TreeMap将不能正常工作。