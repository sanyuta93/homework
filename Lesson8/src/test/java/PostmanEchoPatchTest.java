import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostmanEchoPatchTest {

    @BeforeAll
    public static void setup() {

        RestAssured.baseURI = "https://postman-echo.com";

        RestAssured.useRelaxedHTTPSValidation();
    }

    @Test
    public void testPatchRequestWithBody() {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("id", 123);
        requestBody.put("name", "Test User");
        requestBody.put("active", true);

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("data.id", equalTo(123))
                .body("data.name", equalTo("Test User"))
                .body("data.active", equalTo(true))
                .body("url", equalTo("https://postman-echo.com/patch"))
                .body("headers", hasKey("content-type"))
                .body("headers.content-type", containsString("application/json"));
    }

    @Test
    public void testPatchRequestWithPartialUpdate() {

        String partialUpdateJson = "{\"status\":\"updated\"}";

        given()
                .contentType(ContentType.JSON)
                .body(partialUpdateJson)
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("data.status", equalTo("updated"))
                .body("data.size()", equalTo(1));
    }
}
