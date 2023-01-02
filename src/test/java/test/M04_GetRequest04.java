package test;

import baseUrl.DummyBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import testData.DummyTestData;
import testData.RestfullTestData;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class M04_GetRequest04 extends DummyBaseUrl {
    /*
    http://dummy.restapiexample.com/api/v1/employees url'ine
    accept type'i "application/json" olan GET request'i yolladigimda gelen response'un
        status kodunun 200
        content type'inin "application/json"
        employees sayisinin 24
        employee'lerden birinin "Ashton Cox"
        gelen yaslar icinde 21, 61, ve 23 degerlerinden birinin oldugunu test edin
     */

    // without Testdata class
    @Test
    public void test01(){
        spec02.pathParams("p1", "api", "p2", "v1", "p3", "employees");
        Response response = given().spec(spec02).when().get("{p1}/{p2}/{p3}");

        response.then().assertThat().statusCode(200).contentType("application/json");

        response.then().body("data.employee_name", hasSize(24),
                "data.employee_name", hasItem("Ashton Cox"),
                "data.employee_age", hasItems(21, 23, 61));
    }

    // with Testdata class
    @Test
    public void test02(){
        spec02.pathParams("p1", "api", "p2", "v1", "p3", "employees");
        Response response = given().spec(spec02).when().get("{p1}/{p2}/{p3}");

        DummyTestData expObject = new DummyTestData();
        HashMap<String, Object> expTestData = expObject.expectedEmployeeData();

        response.then().body("data.employee_name", hasSize((Integer) expTestData.get("employee size")),
                "data.employee_name", hasItem(expTestData.get("employee_name")),
                "data.employee_age", hasItems(21, 23, 61));
    }
}
