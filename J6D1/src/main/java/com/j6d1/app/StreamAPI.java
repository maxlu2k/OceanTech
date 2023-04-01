package com.j6d1.app;

import com.j6d1.bean.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {
    static Lambada lm = new Lambada();
    static List<Student> list = lm.getList();
    public static void main(String[] args) {

//        demo1();
//        demo2();
//        demo3();
        demo4();
    }
    public static void  demo4(){
        double avg = lm.getList().stream().mapToDouble(sv->sv.getMarks()).average().getAsDouble();
        System.out.println("avg: "+avg); //trung bình

        double sum = lm.getList().stream().mapToDouble(sv->sv.getMarks()).sum();
        System.out.println("sum: "+sum);

        double min_mark = lm.getList().stream().mapToDouble(sv-> sv.getMarks()).min().getAsDouble();
        System.out.println("min: "+min_mark);

        boolean all_passed = lm.getList().stream().allMatch(sv->sv.getMarks() > 7.5);
        System.out.println("all_passed: "+all_passed);

        Student min_sv = list.stream().reduce(list.get(0),(min,sv) -> sv.getMarks() < min.getMarks() ? sv : min);
        System.out.println("min_sv: "+min_sv);
    }
    public static void  demo1(){
        Stream<Integer> stream1 = Stream.of(1,4,7,6,9,8,2);
        stream1.forEach(s -> System.out.println(s));
    }
    public static void demo2(){
        List<Integer> list = Arrays.asList(1,9,8,7,3,6);
        List<Double> result = list.stream()
                .filter(n ->n % 2 ==0)
                .map(n -> Math.sqrt(n))
                .peek(d -> System.out.println(d))
                .collect(Collectors.toList());
    }
    public static void demo3(){
        List<Student> result = lm.getList().stream()
                .filter(sv->sv.getMarks() >=7.0)
                .peek(sv -> sv.getName())
                .collect(Collectors.toList());
        result.forEach(n -> System.out.println(n));
    }
}
