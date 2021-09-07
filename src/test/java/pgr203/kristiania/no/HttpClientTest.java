package pgr203.kristiania.no;

import org.junit.jupiter.api.Test;


import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HttpClientTest {

    @Test
    void shouldGetSuccessfulResponseCode() throws IOException {
        HttpClient client = new HttpClient("httpbin.org", 80, "/html");
        assertEquals(200, client.getStatusCode());
    }

    @Test
    void shouldGetFailureResponseCode() throws IOException {
        HttpClient client = new HttpClient("httpbin.org", 80, "/status/401");
        assertEquals(401, client.getStatusCode());
    }
}
