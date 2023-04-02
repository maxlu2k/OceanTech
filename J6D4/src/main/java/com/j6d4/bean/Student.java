package com.j6d4.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    String name;
    Double marks;
    Boolean gender;
    Contact contact;
    @JsonIgnore
    public Object[] getArray(){
        return new Object[]{
                getContact().getEmail(),
                getName(),
                getMarks(),
                getGender(),
                getContact().getCountry()
        };
    }
}
