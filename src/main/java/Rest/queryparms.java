package Rest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class queryparms {

    @Test
    public void queryparam() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RequestSpecification request = RestAssured.given();
        Response res =request.queryParam("id","2").get("/todos");
        ResponseBody body = res.body();
        String rbdy = body.asString();
        JsonPath jpath = new JsonPath(rbdy);
        //Storing publisher name in a string variable
        String title = jpath.getString("title");
        System.out.println("The book title is - "+title);
    }
}
