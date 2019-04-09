package com.wd.test;

import android.provider.Settings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void sort() {
        Scanner input = new Scanner(System.in);
        int sort[] = new int[10];
        int temp;
        System.out.println("请输入10个排序的数据：");
        for (int i = 0; i < sort.length; i++) {
            sort[i] = input.nextInt();
        }
        for (int i = 0; i < sort.length - 1; i++) {
            for (int j = 0; j < sort.length - i - 1; j++) 			{
                if (sort[j] < sort[j + 1]) {
                    temp = sort[j];
                    sort[j] = sort[j + 1];
                    sort[j + 1] = temp;
                }
            }
        }
        System.out.println("排列后的顺序为：");
        for(int i=0;i<sort.length;i++){
            System.out.print(sort[i]+"   ");
        }
    }
    public static void main(String[] arge){
        sort();
        person();
        whilefor();
    }
    private static void whilefor() {
        System.out.println("for 循环");
        for (int i=1;i<=10;i++){
            System.out.println("第"+i+"个"+"一寸光阴一寸金");
        }
        System.out.println("while 循环");
        int j=0;
        while (j<10){
            j++;
            System.out.println("第"+j+"个"+"一寸光阴一寸金");
        }
        System.out.println("do while 循环");
        int x=0;
        do {
            x++;
            System.out.println("第"+x+"个"+"一寸光阴一寸金");
        }while (x<10);

    }
    private static void person() {
        System.out.println();
        Person person1=new Person(1,"马化腾",27,36000);
        Person person2=new Person(2,"刘强东",23,23000);
        Person person3=new Person(3,"李彦宏",25,18000);
        Person person4=new Person(4,"周宏伟",21,12000);
        List<Person> list1=new ArrayList<>();
        list1.add(person1);
        list1.add(person2);
        List<Person> list2=new ArrayList<>();
        list2.add(person3);
        list2.add(person4);
        System.out.println("打印 list1 :"+list1.toString());
        System.out.println("打印 list2 :"+list2.toString());
        System.out.println();
        list1.add(list2.get(0));
        list1.add(list2.get(1));
        System.out.println("打印添加后  list1 :"+list1.toString());
        System.out.println();
        list1.remove(list1.get(0));
        list1.remove(list1.get(1));
        System.out.println("打印删除后的 list1:"+list1.toString());
    }
}
