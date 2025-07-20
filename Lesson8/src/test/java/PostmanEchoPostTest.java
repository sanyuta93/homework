import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostmanEchoPostTest {

    @Test
    public void testPostRequestWithBody() {
        // Устанавливаем базовый URL
        RestAssured.baseURI = "https://postman-echo.com";

        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("key1", "value1");
        requestBody.put("key2", "value2");

        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/post");

        response.then().statusCode(200);

        response.then()
                .body("data.key1", equalTo("value1"))
                .body("data.key2", equalTo("value2"))
                .body("url", equalTo("https://postman-echo.com/post"))
                .body("headers", notNullValue())
                .body("headers.content-type", containsString("application/json"))
                .body("headers.host", equalTo("postman-echo.com"));
    }
}