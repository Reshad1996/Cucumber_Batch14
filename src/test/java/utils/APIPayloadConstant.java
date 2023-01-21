package utils;

import org.json.JSONObject;

public class APIPayloadConstant {


    public static String createEmployeePayload(){
        String createEmployeePayload =
               "{\n" +
                       "  \"emp_firstname\": \"Reshad\",\n" +
                       "  \"emp_lastname\": \"Gulzada\",\n" +
                       "  \"emp_middle_name\": \"ms\",\n" +
                       "  \"emp_gender\": \"M\",\n" +
                       "  \"emp_birthday\": \"1996-05-06\",\n" +
                       "  \"emp_status\": \"Confirmed\",\n" +
                       "  \"emp_job_title\": \"QA Engineer\"\n" +
                       "}";
        return createEmployeePayload;
    }

    public static String adminPayload(){
        String adminPayload = "{\n" +
                "  \"email\": \"Reshad@test.com\",\n" +
                "  \"password\": \"Test@123\"\n" +
                "}";

        return adminPayload;
    }

    public static String createEmployeeJsonBody(){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname","Reshad");
        obj.put("emp_lastname","Gulzada");
        obj.put("emp_middle_name","ms");
        obj.put("emp_gender","M");
        obj.put("emp_birthday","1996-05-06");
        obj.put("emp_status","Confirmed");
        obj.put("emp_job_title","QA Engineer");
        return obj.toString();

    }
}
