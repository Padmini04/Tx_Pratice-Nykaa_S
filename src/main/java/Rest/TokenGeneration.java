package Rest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class TokenGeneration {

    public String BasicPath = "https://dummyjson.com/";
    public String generateTokenPath = "auth/login";

    public String token = "";
    public String getUser = "auth/me";

    @Test
    public void  TokenGenerate() {

        RestAssured.baseURI = BasicPath;
        RequestSpecification request = RestAssured.given();
//        Getting the JSON as a string is a necessary step
//        when you're preparing to send a JSON payload as the body of a POST request.
//        In HTTP requests, the body is typically a sequence of bytes, and
//        when you're dealing with data structures like JSON objects in a programming language,
//        you need to convert them to a string representation to be transmitted over the network.
        JSONObject requestParams = new JSONObject();
       requestParams.put("username","kminchelle");
       requestParams.put("password","0lelplR");
        request.header("Content-Type", "application/json");
        request.body(requestParams.toString());
        Response response = request.post(generateTokenPath);
        System.out.println("The status received: " + response.statusLine());
        ResponseBody body = response.getBody();
//        This method is specifically designed to convert the response body content to a String in a human-readable format
        token = body.asString();
//        JsonPath is a library that provides a convenient way to traverse and query JSON structures.
//        By creating a JsonPath object, you can use its methods to extract specific values from the JSON response.
        JsonPath jsonpath = new JsonPath(token);
        String TokenValue = jsonpath.getString("token");
        System.out.println(TokenValue);
         request.header("Authorization", "Bearer " + TokenValue);
         Response getResponse = request.get(getUser);
        ResponseBody getBody = getResponse.getBody();
        System.out.println("response"+getBody.asString());



    }
}
