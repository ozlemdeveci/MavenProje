package com.hrms.Api;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matcher.*;
//given()
//when()
//then()
public class hardCodedExamplesAfterChanged {
    String baseURI = RestAssured.baseURI = "http://3.237.189.167/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MTQyMTgxODgsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTYxNDI2MTM4OCwidXNlcklkIjoiMjM4NSJ9.60dBgtyQzpOswmWLVg4kgsQc3MxWE3iHw9BCAgikDyo";
    @Test
    public void sampleTest() {
//        RestAssured.baseURI = "http://3.237.189.167/syntaxapi/api";
//        String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MTQxMjY1NDEsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTYxNDE2OTc0MSwidXNlcklkIjoiMjQ3NyJ9.HF6XbGuiUjAo8xa1r6Ttum7lUO6Ww32NXK4xRJ8vINo";
        //presparing request to get one employee
        RequestSpecification preparingGetOneEmployeeRequest = given().header("Authorization", token)
                .header("Content-Type", "Application/json")
                .queryParam("employee_id", "13001");
        //sending the request to the endpoint
        Response getOneEmployeeResponse = preparingGetOneEmployeeRequest.when().get("/getOneEmployee.php");
        //print the response
        getOneEmployeeResponse.prettyPrint();
        //Assert that status code is 200
        getOneEmployeeResponse.then().assertThat().statusCode(200);
    }
    @Test
    public void aPostCreateEmployee() {
        //Preparing Create an Employee Request
        RequestSpecification createEmployeeRequest = given().header("Authorization", token)
                .header("Content-Type", "Application/json").body("{\n" +
                        "  \"emp_firstname\": \"Mariii\",\n" +
                        "  \"emp_lastname\": \"Romaniuk\",\n" +
                        "  \"emp_middle_name\": null,\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"2021-02-11\",\n" +
                        "  \"emp_status\": \"employee\",\n" +
                        "  \"emp_job_title\": \"IT Analyst\"\n" +
                        "}");
        //Making a Post call to Create Employee
        Response createEmployeeResponse = createEmployeeRequest.when().post("/createEmployee.php");
        //Printing the Employee Id
        createEmployeeResponse.prettyPrint();
        //Assert that status code is 201
        createEmployeeResponse.then().assertThat().statusCode(201);

        //Get Employee_id
        String employeeID = createEmployeeResponse.jsonPath().getString("Employee[0].employee_id");
        // Print EmployeeId

// 2.way       JsonPath js=createEmployeeResponse.jsonPath();
//        Object employeeID=js.get("Employee[0].employee_id");
//        System.out.println(employeeID);

        //Assert that message contains Entry Created
        createEmployeeResponse.then().assertThat().body("Message",equalTo("Entry Created"));
        //Assert that Employee Id is 15845A
        createEmployeeResponse.then().assertThat().body("Employee[0].emp_firstname",equalTo("Mariii"));
    }
    @Test
    public void bgetCreatedEmployee(){
        RequestSpecification getCreatedEmployee = given().header("Authorization", token)
                .header("Content-Type", "Application/json").queryParam("employee_id","15900A");
        Response getEmployeeResponse = getCreatedEmployee.when().get("/getOneEmployee.php");
//       getEmployeeResponse.prettyPrint();
        String empID=getEmployeeResponse.body().jsonPath().getString("Employee[0].employee_id");
// we are checking if the empid is eqaul to the one mentioned in string
        boolean VerifyEmployeeID=empID.equalsIgnoreCase("15900A");
        System.out.println(VerifyEmployeeID);
        Assert.assertTrue(VerifyEmployeeID);
//        getEmployeeResponse.then().assertThat().body("employee[0].employee_id",equalTo("15900A"));
    }

    @Test
    public void cUpdateEmployee() {
        RequestSpecification updateEmployeeRequest = given().header("Authorization", token)
                .header("Content-Type", "Application/json").body("{\n" +
                        "  \"employee_id\": \"16037A\",\n" +
                        "  \"emp_firstname\": \"ABC\",\n" +
                        "  \"emp_lastname\": \"Romaniuk\",\n" +
                        "  \"emp_middle_name\": null,\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"2021-02-11\",\n" +
                        "  \"emp_status\": \"employee\",\n" +
                        "  \"emp_job_title\": \"IT Analyst\"\n" +
                        "}");
        Response UpdateEmployeeReponse = updateEmployeeRequest.when().put("/updateEmployee.php");
        UpdateEmployeeReponse.prettyPrint();

        //assert that updated information is correct
        JsonPath js = UpdateEmployeeReponse.jsonPath();
        String employee_firstname = js.getString("employee[0].emp_firstname");

        assertThat(employee_firstname, equalTo("ABC"));

        //in other way
       // UpdateEmployeeReponse.then().assertThat().body(employee_firstname, equals("ABC"));
    }
    @Test
    public void dPartiallyUpdateEmployee(){
        RequestSpecification partiallyUpdateRequest = given().header("Authorization", token)
                .header("Content-Type", "Application/json").body("{\n" +
                        "  \"employee_id\": \"15475A\",\n" +
                        "  \"emp_firstname\": \"selam\"\n" +
                        "}");
        Response PartiallyupdatedEmployeeResponse=partiallyUpdateRequest.when()
                .patch("/updatePartialEmplyeesDetails.php");
        PartiallyupdatedEmployeeResponse.prettyPrint();
        //assert that body contains the Message entery updated
        JsonPath js= PartiallyupdatedEmployeeResponse.jsonPath();
        Object Message = js.get("Message");
        System.out.println(Message);
        assertThat(Message,equalTo("Entry updated"));
        //the other method
        PartiallyupdatedEmployeeResponse.then().body("Message", containsString("Entry updated"));
    }

        @Test
    public void deleteEmployeeRequest(){
            RequestSpecification deleteEmployeeReq = given().header("Authorization", token)
                    .header("Content-Type", "Application/json")
                    .queryParam("employee_id","15475A");

            Response deleteReqResponse=deleteEmployeeReq.when().delete("/deleteEmployee.php");

            deleteReqResponse.prettyPrint();

            //assert that msj contains entry deleted message ;
            deleteReqResponse.then().assertThat().body("message",containsString("Entry deleted"));




    }
    }
