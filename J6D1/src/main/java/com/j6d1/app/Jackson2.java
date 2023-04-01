package com.j6d1.app;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.j6d1.bean.Contact;
import com.j6d1.bean.Student2;

import java.io.File;
import java.util.*;

public class Jackson2 {
    public static void main(String[] args) throws Exception{
//        demo1();
//        demo2();
//        demo3();
//        demo4();
//        demo5();
//        demo6();
        demo7();
    }



    public static void demo1() throws Exception{
        String json2 = "C:\\Users\\alvin\\IntelliJWork\\OceanTechL1\\J6D1\\src\\main\\resources\\student.json";
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> students = mapper.readValue(new File(json2), Map.class);
        System.out.println("Name: "+ students.get("name"));
        System.out.println("Marks: "+ students.get("marks"));
        System.out.println("Gender: "+ students.get("gender"));
        Map<String, Object> contact = (Map<String, Object>) students.get("contact");
        System.out.println("Email: "+ contact.get("email"));
        System.out.println("Phone: "+ contact.get("phone"));
        List<String> subjects = (List<String>) students.get("subject");
        subjects.forEach(sub ->{
            System.out.println("Subjects: "+sub);
        });
    }
    public static void demo2() throws Exception{
        String path = "C:\\Users\\alvin\\IntelliJWork\\OceanTechL1\\J6D1\\src\\main\\resources\\students.json";
        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, Object>> students = mapper.readValue(new File(path), List.class);
        students.forEach(st->{
            System.out.println("Name: "+ st.get("name"));
            System.out.println("Gender: "+ st.get("gender"));
            System.out.println("Marks: "+ st.get("marks"));
            System.out.println("Email: "+ st.get("contact"));
        });
    }
    public static void demo3() throws Exception{
        String path = "C:\\Users\\alvin\\IntelliJWork\\OceanTechL1\\J6D1\\src\\main\\resources\\student.json";
        ObjectMapper mapper = new ObjectMapper();
        Student2 students = mapper.readValue(new File(path), Student2.class);

        System.out.println("Name: "+students.getName());
        System.out.println("Gender: "+students.getGender());
        System.out.println("Marks: "+students.getMarks());
        Contact contact = students.getContact();
        System.out.println("Email: "+contact.getEmail());
        System.out.println("Phone: "+contact.getPhone());
        System.out.println("Address: "+contact.getAddress());
        List<String> sub = students.getSubject();
        sub.forEach(s ->{
            System.out.println("Subjects: "+s);
        });
    }
    public static void demo4() throws Exception {
        String path = "C:\\Users\\alvin\\IntelliJWork\\OceanTechL1\\J6D1\\src\\main\\resources\\students.json";
        TypeReference<List<Student2>> type = new TypeReference<List<Student2>>() {}; //chú ý import đúng loại
        ObjectMapper mapper = new ObjectMapper();
        List<Student2> students = mapper.readValue(new File(path),type);
        students.forEach(s->{
            System.out.println("Name: "+ s.getName());
            System.out.println("Email: "+s.getContact().getEmail());
            s.getSubject().forEach(sub->{
                System.out.println("Subjects: "+sub);
            });
            System.out.println("");
        });
    }
    public static void demo5() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode student = mapper.createObjectNode();
        student.put("name","Nguyễn Mạnh Ninh");
        student.put("marks",9.0);
        student.put("gender",true);
        ObjectNode contact = student.putObject("contact");
        contact.put("email","ninh@gmail.com");
        contact.put("phone","090559845");
        ArrayNode subjects = student.putArray("subject");
        subjects.add("WEB205");
        subjects.add("COM108");

        //write đổi sang chuỗi JSON
        String json = mapper.writeValueAsString(student);
        //wirte ra outPut nào đó
        mapper.writeValue(System.out, student);
        //write ra file
        mapper.writeValue(new File("C:\\Users\\alvin\\IntelliJWork\\OceanTechL1\\J6D1\\src\\main\\resources\\writeFileX.json"),student);
    }
    public static void demo6() throws Exception {
        Map<String, Object> contact = new HashMap<String, Object>();
        contact.put("email","ninhV2@gmail.com");
        contact.put("phone","09877744415");

        List<String> subject = Arrays.asList("WEB205","COM108");

        Map<String, Object> student = new HashMap<String,Object>();
        student.put("name","Nguyễn Mạnh Ninh");
        student.put("marks",9.0);
        student.put("gender",true);
        student.put("contact",contact);
        student.put("subject",subject);

        ObjectMapper mapper = new ObjectMapper();
        //write đổi sang chuỗi JSON
        String json = mapper.writeValueAsString(student);
        //wirte ra outPut nào đó
        mapper.writeValue(System.out, student);
        //write ra file
        mapper.writeValue(new File("C:\\Users\\alvin\\IntelliJWork\\OceanTechL1\\J6D1\\src\\main\\resources\\writeFileX.json"),student);
    }

    private static void demo7() throws Exception{
        Contact contact = new Contact("dungV2@gmail.com","0951211515",null);
        List<String> subject = Arrays.asList("WEB205","COM108");
        Student2 student2 = new Student2("Nguyễn Dũng", true,9.0, contact,subject);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(student2);

        mapper.writerWithDefaultPrettyPrinter().writeValue(System.out,student2); //writerWithDefaultPrettyPrinter giúp format lại json

        mapper.writeValue(new File(""),student2);
    }
}
