import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostmanEchoPutTest {

    @Test
    public void testPutRequestWithBody() {

        RestAssured.baseURI = "https://postman-echo.com";



        Response response = given()
                .contentType(ContentType.JSON)
                .body("123")
                .when()
                .put("/put");

        response.then().statusCode(200);

        response.then()
                .body("data", equalTo("123"))
                .body("url", equalTo("https://postman-echo.com/put"))
                .body("headers", notNullValue()) // Проверяем, что headers есть
                .body("headers.content-type", containsString("application/json"))
                .body("headers.host", equalTo("postman-echo.com"));
    }
}

