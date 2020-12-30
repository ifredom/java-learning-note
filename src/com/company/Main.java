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
        // comparingInt(m->m.sequence)
        Set<Message> set = new TreeSet<Message>(Comparator.comparingInt(o1 -> o1.sequence));
        ArrayList<Message> list = new ArrayList<>();
        for (Message item:received){
            set.add(item);
        }
        System.out.println(set);
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
