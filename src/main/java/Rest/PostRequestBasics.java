package Rest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PostRequestBasics {
    @Test
    public void PostRequest()
    {
//        Create a Request pointing to the Service Endpoint
        RestAssured.baseURI="https://jsonplaceholder.typicode.com/";
        RequestSpecification request = RestAssured.given();
//        create post request with simple payload
//        String jsonString = "{\"userId\": 11,\n" +
//                "    \"id\": 2,\n" +
//                "    \"title\": \"chlo chlta hai\",\n" +
//                "    \"completed\": false}";
//        Create a JSON request which contains all the fields          z
        JSONObject requestParams = new JSONObject();
        requestParams.put("userId", "TQ123");
        requestParams.put("isbn", "9781449325862");
        request.header("Content-Type", "application/json"); // Add the Json to the body of the request
        request.body(requestParams.toJSONString());
        Response response = request.post("todos");
        System.out.println("The status received: " + response.statusLine());
        ResponseBody body = response.getBody();
        System.out.println(body.asString());









    }

}
