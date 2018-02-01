/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import addressbook.model.LogMessage;
import com.google.gson.Gson;
import java.sql.Timestamp;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alex
 */
public class LogMessageWebServiceTest {

    @Test
    public void testGetPeople() {
        Client client = ClientBuilder.newClient();
        Response response = client
                .target("http://localhost:8888/api")
                .path("logmessages").request().get();

        assertEquals(200, response.getStatus());
    }

    @Test
    public void testAddLogMessage() {
        fail("Test not implemented.");
    }
}
