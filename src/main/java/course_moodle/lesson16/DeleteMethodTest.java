package course_moodle.lesson16;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteMethodTest {

    @Test
    public void testDeleteMethod() {
        Response response = RestAssured.delete("https://postman-echo.com/delete");

        assertEquals(200, response.getStatusCode());
    }
}
