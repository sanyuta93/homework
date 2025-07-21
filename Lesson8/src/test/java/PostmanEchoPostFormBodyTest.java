import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostmanEchoPostFormBodyTest {

    @Test
    public void testPostRequestWithFormBody() {

        RestAssured.baseURI = "https://postman-echo.com";

        Response response = given()
                .header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8") // Explicit charset
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .log().all()  // Log request details
                .when()
                .post("/post");

        response.then()
                .log().all()  // Log response details
                .statusCode(200)
                .body("url", equalTo("https://postman-echo.com/post"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.content-type", containsString("application/x-www-form-urlencoded"))
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"));
    }


}