package utils;

import APISteps.APIWorkFlowSteps;
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


    public static String createEmployeePayloadDynamic(String firstname, String lastname, String middlename,
                                                      String gender, String dob,
                                                      String empStatus, String jobTitle){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", firstname);
        obj.put("emp_lastname", lastname);
        obj.put("emp_middle_name", middlename);
        obj.put("emp_gender", gender);
        obj.put("emp_birthday", dob);
        obj.put("emp_status", empStatus);
        obj.put("emp_job_title",jobTitle);
        return obj.toString();
    }


    public static String updateEmployeePayloadDynamic(String empId, String Fname, String Lname, String Mname,
                                                      String Gender, String DOB, String empStatus, String jobTitle) {


        JSONObject obj = new JSONObject();
        obj.put("employee_id", empId);
        obj.put("emp_firstname",Fname);
        obj.put("emp_lastname", Lname);
        obj.put("emp_middle_name", Mname);
        obj.put("emp_gender", Gender);
        obj.put("emp_birthday", DOB);
        obj.put("emp_status", empStatus);
        obj.put("emp_job_title",jobTitle);
        return obj.toString();

    }

}
