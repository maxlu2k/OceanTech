package com.j6d1.app;

import com.j6d1.bean.Student;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Lambada {
    public static List<Student> list = Arrays.asList(
            new Student("Minh",true,6.5),
            new Student("Long",true,6.5),
            new Student("Hương",false,4.5),
            new Student("Giang",false,9.5),
            new Student("Hiền",false,5.5),
            new Student("Hoà",false,7.5)
    );
    public List<Student> getList(){
        return list;
    }
    public static void main(String[] args) {
//        demo1();
//        demo2();
//        demo3();
        demo4();
//        streamListDemo();
//stream-Match
//        demoMatch();
//        demoMapToDouble();
//        demoT();

    }

    private static void demoT() {
        Stream.of(list).forEach(System.out::println);
    }

    private static void demoMapToDouble() {
        //tổng các điểm
        Double mark = list.stream().mapToDouble(sv ->sv.getMarks()).sum(); //maptodouble trả về một optional và cuối cùng là phương thứuc trả ra kq
        System.out.println(mark);
    }
    //phương thức kết thúc "forEach(),collect()"

    private static void demoMatch() {
        if (list.stream().allMatch(sv -> sv.getMarks() > 0)){
            System.out.println("allMatch");
        }else {
            System.out.println("test");

        }
    }

    private static void streamListDemo() {
        Stream<Student> sList = list.stream().filter(sv -> sv.getMarks() > 7.0);
        sList.forEach(sv -> {
            System.out.println("Name: "+sv.getName());
            System.out.println("Marks: "+sv.getMarks());
            System.out.println("");
        });

    }

    private static void demo4() {
        Demo4inter o =(int x) -> {
            System.out.println(x);
        };
//        Demo4inter ox =  new Demo4inter() {
//            @Override
//            public void m1(int x) {
//                System.out.println(x);
//            }
//        };
        o.m1(2021);
    }

    private static void demo3() {
        Collections.sort(list,(sv1,sv2)-> {return +sv1.getMarks().compareTo(sv2.getMarks());});
        list.forEach(sv -> {
            System.out.println("Name: "+sv.getName());
            System.out.println("Marks: "+sv.getMarks());
            System.out.println("");
        });
    }

    private static void demo2() {
        list.forEach(sv -> {
            System.out.println("Name: "+sv.getName());
            System.out.println("Gender: "+sv.getGender());
            System.out.println("Marks: "+sv.getMarks());
            System.out.println("");
        });
    }

    private static void demo1() {
        List<Integer> list = Arrays.asList(1,9,4,7,5,2);
        list.forEach(n -> System.out.println(n));
    }
    @FunctionalInterface
    interface Demo4inter{
        void m1(int x);
        default void m2(){

        }
        static void m3(){}
    }
}
