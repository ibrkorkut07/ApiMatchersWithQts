package test;

import baseUrl.RestfullBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class M01_GetRequest01 extends RestfullBaseUrl {

   /*
    https://restful-booker.herokuapp.com/booking/3 adresine bir request gonderildiginde
    donecek cevap(response) icin
        HTTP status kodunun 200
        Content Type’in Json
        Ve Status Line’in HTTP/1.1 200 OK
    Oldugunu test edin
   */

    @Test
    public void test01() {

        spec01.pathParams("p1", "booking", "p2", "3");
        Response response = given().spec(spec01).when().get("{p1}/{p2}");

        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).statusLine("HTTP/1.1 200 OK");
    }
}
