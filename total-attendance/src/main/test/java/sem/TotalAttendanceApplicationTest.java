package sem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.web.util.UriComponentsBuilder;
import sem.totalattendance.TotalAttendanceApplication;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = TotalAttendanceApplication.class)
public class TotalAttendanceApplicationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    // to test the success case
    @Test
    public void testTotalAttendanceApplication() {
        String[] args = {"1", "2", "3", "4", "5"};
        UriComponentsBuilder builder = UriComponentsBuilder.fromPath("/");
        for (String arg : args) {
            builder.queryParam("attendance", arg);
        }
        System.out.println(builder.toUriString());

        String url = builder.toUriString();

        HashMap result;
        result = this.restTemplate.getForObject(url, HashMap.class);
        System.out.println(result);

        assertThat(result).containsKey("result");
        assertThat(result).containsKey("status");
        assertEquals(result.get("result"), "15.0");
        assertEquals(result.get("status"), "200");

    }

    // to test the error case. where the input is not a number.
    @Test
    public void testTotalAttendanceInvalidInput() {
        String[] args = {"1", "2", "3", "4", "5", "a"};
        UriComponentsBuilder builder = UriComponentsBuilder.fromPath("/");
        for (String arg : args) {
            builder.queryParam("attendance", arg);
        }
        System.out.println(builder.toUriString());

        String url = builder.toUriString();

        HashMap result;
        result = this.restTemplate.getForObject(url, HashMap.class);
        System.out.println(result);

        assertThat(result).containsKey("result");
        assertThat(result).containsKey("status");
        assertEquals(result.get("result"), "Error: Invalid input. Please enter a comma separated list of numbers.");
        assertEquals(result.get("status"), "400");

    }
}
