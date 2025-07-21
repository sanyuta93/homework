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
