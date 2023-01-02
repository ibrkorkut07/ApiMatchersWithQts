package test;

import org.junit.Test;

import static io.restassured.RestAssured.given;

public class M23_PutRequest01 {
    /*
    https://jsonplaceholder.typicode.com/todos/198 URL ine aşağıdaki body gönerdiğimde

 {
 "userId": 21,
 "title": "Wash the dishes",
 "completed": false
 }
 Dönen response un status kodunun 200 ve body kısmının aşağıdaki gibi olduğunu test edin
 {
 "userId": 21,
 "title": "Wash the dishes",
 "completed": false,
 "id": 198
 }
     */

    @Test
    public void test(){


    }
}
