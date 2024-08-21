import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class PostmanEchoTest {
    @Test
    void shouldReturnSendDate() {
        String text = "Hello World";
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("Hello World")
                .when().log().all()
                .post("/post")
                .then().log().all()
                .statusCode(200)
                .body( "data", org.hamcrest.Matchers.equalTo("Hello"));
    }
}
