package com.j6d1.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student2 {
    String name;
    Boolean gender = true;
    Double marks = 0.0;
    Contact contact;
    List<String> subject;
}
