package APIPackage;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

// to change the order of execution we use FixMethodOrder since it is executing in top
// which is not got for us
// this method sorters will execute in ascending/alphabatical order
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamples {

    // one thing to remember
    // base URI - base URL
    // and then using when keyword, we will send the end point

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";


    // we need to perform CRUD operations
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2NzQwODc4NjYsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY3NDEzMTA2NiwidXNlcklkIjoiNDg5NSJ9.Fal00kqQhTSJrMRPc8RpaXfVYTuI8valu7AqBNh9bnw";
    static String employee_id;

    @Test
    public void bgetOneEmployee() {
        // Prepare the request
        // to Prepare the request,  we use RequestSpecification
        RequestSpecification request = given().header("Authorization",token)
                .header("Content-Type","application/json").queryParam("employee_id",employee_id);


        // to hit the end point/ to make the request which will return respose
        Response response = request.when().get("/getOneEmployee.php");

       // System.out.println(response.asString());
        response.prettyPrint();

        // Verifying the status code
        response.then().assertThat().statusCode(200);

        // using jsonPath method, we are extracting the value from the response body
        String firstName = response.jsonPath().getString("employee.emp_firstname");
        System.out.println(firstName);

        // first way of assertion
        Assert.assertEquals(firstName,"Reshad");

        //second way of assertion to verify the value in response body using hamcrest matchers
        response.then().assertThat().body("employee.emp_firstname",equalTo("Reshad"));
    }

    @Test
    public void aCreateEmployee(){
        RequestSpecification request = given().header("Authorization",token)
                .header("Content-Type","application/json")
                .body("{\n" +
                        "  \"emp_firstname\": \"Reshad\",\n" +
                        "  \"emp_lastname\": \"Gulzada\",\n" +
                        "  \"emp_middle_name\": \"ms\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"1996-05-06\",\n" +
                        "  \"emp_status\": \"Confirmed\",\n" +
                        "  \"emp_job_title\": \"QA Engineer\"\n" +
                        "}");

       Response response = request.when().post("/createEmployee.php");
       response.prettyPrint();

       // Verfying the status code which is 201
        response.then().assertThat().statusCode(201);

        //getting the employee id from the response and use it as static one
        employee_id = response.jsonPath().getString("Employee.employee_id");
        System.out.println(employee_id);
        response.then().assertThat().body("Employee.emp_lastname",equalTo("Gulzada"));
        response.then().assertThat().body("Employee.emp_middle_name",equalTo("ms"));

        // verifying console header
        response.then().assertThat().header("Server","Apache/2.4.39 (Win64) PHP/7.2.18");

    }


    @Test
    public void cupdateEmployee(){
        RequestSpecification request = given().header("Authorization",token)
                .header("Content-Type","application/json")
                .body("{\n" +
                        "  \"employee_id\": \""+employee_id+"\",\n" +
                        "  \"emp_firstname\": \"Haris\",\n" +
                        "  \"emp_lastname\": \"Arsalan\",\n" +
                        "  \"emp_middle_name\": \"ms\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2016-03-15\",\n" +
                        "  \"emp_status\": \"Active\",\n" +
                        "  \"emp_job_title\": \"Kids leader\"\n" +
                        "}");

        Response response = request.when().put("/updateEmployee.php");
        response.prettyPrint();


        // Verfying the status code which is 200
        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("Message",equalTo("Employee record Updated"));
    }

    @Test
    public void dgetUpdatedEmployee(){
        RequestSpecification request = given().header("Authorization",token)
                .header("Content-Type","application/json").queryParam("employee_id",employee_id);


        // to hit the end point/ to make the request which will return respose
        Response response = request.when().get("/getOneEmployee.php");

        // System.out.println(response.asString());
        response.prettyPrint();

        // Verifying the status code
        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("employee.emp_job_title",equalTo("Kids leader"));
    }

}
