package course_moodle.lesson16;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetMethodTest {

    @Test
    public void testGetMethod() {
        Response response = RestAssured.get("https://postman-echo.com/get?foo1=bar1&foo2=bar2");

        assertEquals(200, response.getStatusCode());
        assertEquals("bar1", response.jsonPath().getString("args.foo1"));
        assertEquals("bar2", response.jsonPath().getString("args.foo2"));
    }
}
