package com.j6d1.bean;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {
    private String name;
    private Boolean gender;
    private Double marks = 0.0;

    public enum Gender
    {
        MALE,
        FEMALE
    }
}
