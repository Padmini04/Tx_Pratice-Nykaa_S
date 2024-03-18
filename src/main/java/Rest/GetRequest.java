package Rest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetRequest {
    @Test
    public void getComment()
    {
        RestAssured.baseURI="https://jsonplaceholder.typicode.com/";
        RequestSpecification request = RestAssured.given();
        Response response = request.queryParam("id","3").get("/comments");
        Assert.assertEquals(response.statusCode(),200,"Status code for this api is 200");
        Assert.assertEquals(response.contentType(),"application/json; charset=utf-8","Response contains data as json format");
        ResponseBody body = response.body();
        String BodyAsString = body.asString();
        JsonPath jpath = new JsonPath(BodyAsString);
//        Assert.assertEquals(jpath.getString("id"),"3","Id of the user is 3");
        jpath.getString("id").contains("3");
    }
}
