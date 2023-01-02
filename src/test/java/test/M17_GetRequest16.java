package test;

import org.junit.Test;

import static io.restassured.RestAssured.given;

public class M17_GetRequest16 {
    /*
    https://restful-booker.herokuapp.com/booking/2 url’ine bir get request gönderildiğinde,
    status kodun 200 ve response body’nin
    {   "firstname": "Susan",
        "lastname": "Smith",
        "totalprice": 401,
        "depositpaid": true,
        "bookingdates": {
                "checkin": "2015-12-16",
                "checkout": "2017-03-17"
    },
    "additionalneeds": "Breakfast"
    Olduğunu Object Mapper kullanarak test edin
     */

    // without Testdata class
    @Test
    public void test01(){


    }

    // with Testdata class
    @Test
    public void test02(){


    }
}
