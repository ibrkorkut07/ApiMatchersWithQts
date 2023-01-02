package test;

import org.junit.Test;

import static io.restassured.RestAssured.given;

public class M18_PostRequest01 {
    /*
    http://dummy.restapiexample.com/api/v1/create url ine, Request Body olarak
    {
        "name":"Ahmet Aksoy",
        "salary":"1000",
        "age":"18",
    }
    gönderildiğinde,Status kodun 200 olduğunu ve dönen response body nin ,
    {
        "status": "success",
        "data": {
        “id”:…
    },
    "message": "Successfully! Record has been added."
    }   olduğunu test edin
    */

    @Test
    public void test(){


    }
}
