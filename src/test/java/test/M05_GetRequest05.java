package test;

import baseUrl.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;
import testData.JsonplaceholderTestData;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class M05_GetRequest05 extends JsonplaceholderBaseUrl {
    /*
    https://jsonplaceholder.typicode.com/todos/123 url'ine
    accept type'i "application/json" olan GET request'i yolladigimda gelen response’un
        status kodunun 200
        content type'inin "application/json"
        Headers'daki "Server" in "cloudflare"
        response body'deki "userId"'nin 7
        "title" in "esse et quis iste est earum aut impedit"
        "completed" bolumunun false oldugunu test edin
    */

    // without Testdata class
    @Test
    public void test01(){
        spec03.pathParams("p1", "todos", "p2", "123");
        Response response = given().spec(spec03).when().get("{p1}/{p2}");

        response.then().assertThat().statusCode(200).contentType("application/json").
                headers("Server", equalTo("cloudflare")).
                body("userId", equalTo(7),
                        "title", equalTo("esse et quis iste est earum aut impedit"),
                        "completed", equalTo(false));
    }

    // with Testdata class
    @Test
    public void test02(){
        JsonplaceholderTestData testDataObject = new JsonplaceholderTestData();
        HashMap<String, Object> expData = testDataObject.todos123Data();

        spec03.pathParams("p1", "todos", "p2", "123");
        Response response = given().spec(spec03).when().get("{p1}/{p2}");

        response.then().assertThat().statusCode((Integer) expData.get("statusCode")).
                contentType(ContentType.JSON).
                headers("Server", equalTo(expData.get("Server"))).
                body("userId", equalTo(expData.get("userId")),
                        "title", equalTo(expData.get("title")),
                        "completed", equalTo(expData.get("completed")));

    /*
        todos123ExpData.put("statusCode", 200);
        todos123ExpData.put("contentType", "application/json");
        todos123ExpData.put("Server", "cloudflare");
        todos123ExpData.put("userId", 7);
        todos123ExpData.put("title", "esse et quis iste est earum aut impedit");
        todos123ExpData.put("completed", false);
     */
    }
}
