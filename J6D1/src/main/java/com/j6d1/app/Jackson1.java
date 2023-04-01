package com.j6d1.app;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Jackson1 {
    public static void main(String[] args) throws Exception {
//        demo1();
        demo2();
    }
    public static void demo1() throws Exception{
        String json = "{\r\n"+
                "   \"name\":\"Nguyễn Thị Ninh\",\r\n" +
                "   \"gender\":true,\r\n" +
                "   \"marks\":7.0,\r\n" +
                "   \"contact\":{\r\n" +
                "       \"email\":\"ninh@gmail.com\",\r\n" +
                "       \"phone\":\"0905591555\"\r\n" +
                "   },\r\n" +
                "   \"subject\":[\"WEB205\",\"COM108\"]\r\n" +
                "   }";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode student = mapper.readTree(json);
        System.out.println("Name: "+student.get("name").asText());
        System.out.println("Marks: "+student.get("marks").asDouble());
        System.out.println("Gender: "+student.get("gender").asBoolean());
        System.out.println("Email: "+student.get("contact").get("email").asText());
        System.out.println("Phone: "+student.findValue("phone").asText()); //find value tự động đi tìm giá trị đó
        student.get("subject").iterator().forEachRemaining(sub ->{ // json -> đổi qua iterator() và dùng vòng lặp để duyệt qua -> lấy ra asText()
            System.out.println("Subjects: "+sub.asText());
        });

    }
    public static void demo2() throws Exception{
        String json2 = "C:\\Users\\alvin\\IntelliJWork\\OceanTechL1\\J6D1\\src\\main\\resources\\students.json";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode student = mapper.readTree(new File(json2));
        student.iterator().forEachRemaining(st -> {
            System.out.println("name: "+ st.get("name").asText());
        });
    }
}
