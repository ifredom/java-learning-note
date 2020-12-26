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