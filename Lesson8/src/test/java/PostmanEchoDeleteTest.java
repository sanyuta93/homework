import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostmanEchoDeleteTest {

    @BeforeAll
    public static void setup() {

        RestAssured.baseURI = "https://postman-echo.com";

        RestAssured.useRelaxedHTTPSValidation();
    }

    @Test
    public void testDeleteRequestWithQueryParams() {

        given()
                .queryParam("id", "12345")
                .queryParam("user", "testuser")
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("args.id", equalTo("12345"))
                .body("args.user", equalTo("testuser"))
                .body("url", equalTo("https://postman-echo.com/delete?id=12345&user=testuser"))
                .body("headers", hasKey("host"))
                .body("headers.host", equalTo("postman-echo.com"));
    }

    @Test
    public void testDeleteRequestWithBody() {

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("resourceId", 789);
        requestBody.put("comment", "Marked for deletion");


        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("data.resourceId", equalTo(789))
                .body("data.comment", equalTo("Marked for deletion"))
                .body("url", equalTo("https://postman-echo.com/delete"));
    }

    @Test
    public void testSimpleDeleteRequest() {

        given()
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("args", anEmptyMap())
                .body("data", equalTo(""))
                .body("url", equalTo("https://postman-echo.com/delete"));
    }
}
