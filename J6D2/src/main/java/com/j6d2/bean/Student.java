package com.j6d2.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    String name;
    Boolean gender = false;
    Double marks=0.0;
    Contact contact;
    List<String> subject;
}
