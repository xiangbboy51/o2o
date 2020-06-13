package com.atom.o2o;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: li xiang
 * Date: 2020/6/14 1:22
 */

public class Test {
    class Person {
        public int age;
        public String name;
    }

    int a = 0;
    Integer b = 0;

    List<Integer> list = new ArrayList<>();

    public void test1() {
        goInt(a);
        System.out.println(a);
        gonInteger(b);
        System.out.println(b);
        list.add(a);

        goList(list);
        System.out.println(list.get(0));
        Person p = new Person();
        p.name = "阿三";
        p.age = 1;
        goPerson(p);

        System.out.println(p.name+":"+p.age);


    }


    public static void main(String[] args) {
        new Test().test1();
    }


    public void gonInteger(Integer integer) {
        integer += 1;
    }

    public void goInt(int i) {
        i += 1;
    }

    public void goList(List<Integer> list) {
        int x = list.get(0);
        x = 100;
    }

    public void goPerson(Person p) {
        p.name = "更改后";
        p.age = 18;
    }


}
