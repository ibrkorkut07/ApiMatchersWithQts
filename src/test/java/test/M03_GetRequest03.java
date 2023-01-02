package test;

import baseUrl.RestfullBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import testData.RestfullTestData;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;


public class M03_GetRequest03 extends RestfullBaseUrl {

    /*
    https://restful-booker.herokuapp.com/booking/7 url'ine
        accept type'i "application/json" olan GET request'i yolladigimda gelen response'un
        status kodunun 200 ve
        content type'inin "application/json"

            "firstname": "Susan",
            "lastname": "Brown",
            "totalprice": 189,
            "depositpaid": false,
            "bookingdates": {
                    "checkin": "2017-08-15",
                    "checkout": "2018-12-01"
    }
        oldugunu test edin
    */

    // without Testdata class
    @Test
    public void test01(){

        spec01.pathParams("p1", "booking", "p2", "1");
        Response response1 = given().contentType("application/json").spec(spec01).when().get("{p1}/{p2}");

        response1.then().assertThat().statusCode(200).contentType("application/json");

        response1.then().body("firstname", equalTo("Susan"),
                "lastname", equalTo("Brown"),
                "totalprice", equalTo(189),
                "depositpaid", equalTo(false),
                "bookingdates.checkin", equalTo("2017-08-15"),
                "bookingdates.checkout", equalTo("2018-12-01"));
    }

    // with Testdata class
    @Test
    public void test02(){

        spec01.pathParams("p1", "booking", "p2", "1");
        Response response2 = given().contentType(ContentType.JSON).spec(spec01).when().get("{p1}/{p2}");

        HashMap<String, Object> actData = response2.as(HashMap.class);

        RestfullTestData bookingObject = new RestfullTestData();
        HashMap<String, Object> expData = bookingObject.booking1ExpDataSetUp();

        response2.then().statusCode((Integer) expData.get("statusCode")).
                headers("contentType", equalTo(expData.get("contentType")),
                        "Via", equalTo(expData.get("Via"))).
                body("firstname", equalTo(expData.get("firstname")),
                "lastname", equalTo(expData.get("lastname")),
                "totalprice", equalTo(expData.get("totalprice")),
                "depositpaid", equalTo(expData.get("depositpaid")),
                "bookingDates.checkin", equalTo(expData.get("bookingDates.checkin")),
                "bookingDates.checkout", equalTo(expData.get("bookingDates.checkout")));

    }
}
