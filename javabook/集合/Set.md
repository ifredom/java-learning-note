# Set
> hashSet TreeSet

> TreeSet和使用TreeMap的要求一样，添加的元素必须要实现 `Comparable`接口，
> 如果没有实现`Comparable`接口，那么必须传入`Comparator`对象

## 去重示例

```java
package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        List<Message> received = List.of(
            new Message(1, "Hello!"),
            new Message(2, "发工资了吗？"),
            new Message(2, "发工资了吗？"),
            new Message(3, "去哪吃饭？"),
            new Message(3, "去哪吃饭？"),
            new Message(4, "Bye")
        );
        List<Message> displayMessages = process(received);
        for (Message message : displayMessages) {
            System.out.println(message.text);
        }
    }

    static List<Message> process(List<Message> received) {
        // TODO: 按sequence去除重复消息
        // 1.由于要传入的对象Message没有实现Comparable接口，那么必须传入一个Comparator对象
        Set<Message> set = new TreeSet<Message>(Comparator.comparingInt(m->m.sequence));
        ArrayList<Message> list = new ArrayList<>();

        add.addAll(received);
        list.addAll(set);

        return list;
    }
}

class Message {
    public final int sequence;
    public final String text;
    public Message(int sequence, String text) {
        this.sequence = sequence;
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;
        Message message = (Message) o;
        return sequence == message.sequence && Objects.equals(text, message.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sequence, text);
    }
}

```