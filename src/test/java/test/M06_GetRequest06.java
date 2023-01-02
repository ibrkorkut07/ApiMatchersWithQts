package test;

import baseUrl.RestfullBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;
import testData.RestfullTestData;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class M06_GetRequest06 extends RestfullBaseUrl {
    /*
    https://restful-booker.herokuapp.com/booking/5 url’ine bir request yolladigimda
    HTTP Status Code’unun 200
    response content type’inin “application/JSON” oldugunu
    response body’sinin asagidaki gibi oldugunu test edin
      { "firstname": Sally,
        "lastname": "Smith",
        "totalprice": 789,
        "depositpaid": false,
        "bookingdates": {
               "checkin": "2017-12-11",
               "checkout":"2020-02-20"  }
    */

    // without Testdata class
    @Test
    public void test01(){
        spec01.pathParams("p1", "booking", "p2", "5");
        Response response = given().spec(spec01).when().get("{p1}/{p2}");
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);
        response.then().body("firstname", equalTo("Mary"),
                "lastname", equalTo("Smith"),
                "totalprice", equalTo(243),
                "depositpaid", equalTo(true),
                "bookingdates.checkin", equalTo("2017-02-27"),
                "bookingdates.checkout", equalTo("2020-06-26"));
    }

    // with Testdata class
    @Test
    public void test02(){
        spec01.pathParams("p1", "booking", "p2", "5");
        Response response = given().spec(spec01).when().get("{p1}/{p2}");

        RestfullTestData restfullTestDataObject = new RestfullTestData();
        HashMap<String, Object> booking5ExpData = restfullTestDataObject.booking5ExpDataSetUp();

        response.then().statusCode((Integer) booking5ExpData.get("statusCode")).
                contentType((String) booking5ExpData.get("contentType")).
                body("firstname", equalTo(booking5ExpData.get("firstname")),
                        "lastname", equalTo(booking5ExpData.get("lastname")),
                        "totalprice", equalTo(booking5ExpData.get("totalprice")),
                        "depositpaid", equalTo(booking5ExpData.get("depositpaid")),
                        "checkin", equalTo(booking5ExpData.get("bookingdates.checkin")),
                        "checkout", equalTo(booking5ExpData.get("bookingdates.checkout")));

        /*
        bookingDates.put("checkin", "2016-10-04");
        bookingDates.put("checkout", "2021-12-06");
        HashMap<String, Object> booking5ExpData = new HashMap<>();
        booking5ExpData.put("statusCode", 200);
        booking5ExpData.put("contentType", "application/json; charset=utf-8");
        booking5ExpData.put("firstname", "Jim");
        booking5ExpData.put("lastname", "Jackson");
        booking5ExpData.put("totalprice", 880);
        booking5ExpData.put("depositpaid", false);
        booking5ExpData.put("bookingdates", bookingDates);
        */

    }
}
