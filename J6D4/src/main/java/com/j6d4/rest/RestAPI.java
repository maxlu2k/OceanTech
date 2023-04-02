package com.j6d4.rest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@Controller
public class RestAPI {
    private static ObjectMapper mapper = new ObjectMapper();

    public static JsonNode get(String path){
        return request("GET",path,null);
    }
    public static JsonNode post(String path,Object data){
        return request("POST",path,data);
    }
    public static JsonNode put(String path,Object data){
        return request("PUT",path,data);
    }
    public static JsonNode delete(String path){
        return request("DELETE",path,null);
    }


    private static JsonNode request(String method, String path, Object data){
        try {
            //request
            String uri = "https://java-6-f6778-default-rtdb.asia-southeast1.firebasedatabase.app" +path+".json";
            URL url = new URL(uri);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Accept","applicaton/json");

            //data (post & put only)
            if (method.equalsIgnoreCase("POST") || method.equalsIgnoreCase("PUT")){
                conn.setDoOutput(true);
                mapper.writeValue(conn.getOutputStream(),data);
            }

            //response
            int responseCode = conn.getResponseCode();
            if(responseCode == 200){
                return mapper.readTree(conn.getInputStream());
            }
            conn.disconnect();
            return null;
        }catch (IOException e){
            System.out.println("error ~~"+ e);
            throw new RuntimeException();
        }
    }
}
