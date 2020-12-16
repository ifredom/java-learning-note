package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        double a = 0.4f;
        double b = 0.2f;
        double c = a*b;
        float f1 = 16777215f;
        person("java",12);
    }

    public  static void person(String name,int age){
        int[] arr = {1,2,3,4};
        List list = Arrays.asList(arr);
        Collections.swap(list, 0, 4);
        for (int i:arr) {
            System.out.println(i);
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(list);
    }
}
