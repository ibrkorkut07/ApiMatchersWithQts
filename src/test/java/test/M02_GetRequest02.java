package test;

import baseUrl.RestfullBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class M02_GetRequest02 extends RestfullBaseUrl {

    /*
    https://restful-booker.herokuapp.com/booking url'ine
        accept type'i "application/json" olan GET request'i yolladigimda gelen response'un
        status kodunun 200
        content type'inin "application/json" oldugunu test edin
    */

    @Test
    public void test01(){

        spec01.pathParams("p1", "booking");
        Response response = given().contentType("application/json").spec(spec01).when().get("{p1}");

        response.then().assertThat().statusCode(200).contentType("application/json");
    }
}
