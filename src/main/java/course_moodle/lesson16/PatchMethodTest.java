package course_moodle.lesson16;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PatchMethodTest {

    @Test
    public void testPatchMethod() {
        String requestBody = "{\n" +
                "  \"foo1\": \"bar1\",\n" +
                "  \"foo2\": \"bar2\"\n" +
                "}";

        Response response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .patch("https://postman-echo.com/patch");

        assertEquals(200, response.getStatusCode());
        assertEquals("bar1", response.jsonPath().getString("json.foo1"));
        assertEquals("bar2", response.jsonPath().getString("json.foo2"));
    }
}
