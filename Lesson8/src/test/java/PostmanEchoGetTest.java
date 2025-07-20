import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostmanEchoGetTest {

    @Test
    public void testGetRequestWithQueryParams() {

        RestAssured.baseURI = "https://postman-echo.com";

        Response response = given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get");

        response.then().statusCode(200);

        response.then()
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"))
                .body("headers", notNullValue())
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.host", equalTo("postman-echo.com"));
    }
}
