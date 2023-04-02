package com.j6d4.dao;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.j6d4.bean.Student;
import com.j6d4.bean.StudentMap;
import com.j6d4.rest.RestAPI;

public class StudentDao {
    ObjectMapper mapper = new ObjectMapper();

    public StudentMap findAll(){
        JsonNode resp = RestAPI.get("/students");
        return mapper.convertValue(resp, StudentMap.class);
    }
    public Student findByKey(String key){
        JsonNode resp = RestAPI.get("/students/"+ key);
        return mapper.convertValue(resp, Student.class);
    }
    public String create(Student data){
        JsonNode resp = RestAPI.post("/students", data);
        return resp.get("name").asText();
    }
    public Student update(String key, Student data){
        JsonNode resp = RestAPI.put("/students/"+key , data);
        return mapper.convertValue(resp, Student.class);
    }
    public void delete(String key){
       RestAPI.delete("/students/"+key);
    }

}
