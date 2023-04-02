package com.v2j6d4.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.JsonNode;
import com.v2j6d4.bean.Student;
import com.v2j6d4.map.StudentMap;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import javax.swing.text.html.parser.Entity;

@Repository
public class StudentDao {
    RestTemplate rest = new RestTemplate();

    String url = "https://java-6-f6778-default-rtdb.asia-southeast1.firebasedatabase.app/student.json";
    private String getUrl(String key){
        return url.replace(".json","/"+key+".json");
    }
    public StudentMap findAll(){
        return rest.getForObject(url,StudentMap.class);
    }
    public Student findByKey(String key){
        return rest.getForObject(getUrl(key),Student.class);
    }

    public String create(Student data){
        HttpEntity<Student> entity = new HttpEntity<>(data);
        JsonNode resp = rest.postForObject(url,entity,JsonNode.class);
        return resp.get("name").asText();
    }

    public Student update(String key,Student data){
        HttpEntity<Student> entity = new HttpEntity<>(data);
        rest.put(getUrl(key),entity);
        return data;
    }
    public void delete(String key){
        rest.delete(getUrl(key));
    }
}
