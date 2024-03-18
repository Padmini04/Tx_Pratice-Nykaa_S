package Rest;


import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetResponse {
@Test
    public void getResponse()
{
    RequestSpecification req = RestAssured.given();
    RestAssured.baseURI="https://restful-booker.herokuapp.com/booking";
    Response res = req.request(Method.GET,"");
    String resString = res.asString();
    System.out.println("Response detail" + resString);
//    Get all the headers and then iterate over allHeaders to print each header
    Headers allHeaders = res.headers();
    // Iterate over all the Headers
    for(Header header : allHeaders) {
        System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
    }
// Access header with a given name. Header = Content-Type
    String contentType = res.header("Content-Type");
    Assert.assertEquals(contentType /* actual value */, "application/json; charset=utf-8" /* expected value */);
    // Retrieve the body of the Response
    ResponseBody body = res.getBody();
    System.out.println("Response Body is: " + body.asString());

}


}
