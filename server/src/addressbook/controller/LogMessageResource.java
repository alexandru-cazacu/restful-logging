/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook.controller;

import addressbook.model.DatabaseManager;
import addressbook.model.LogMessage;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 *
 * @author Alexandru Cazacu
 */
@Path("logmessages")
public class LogMessageResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLogMessages(
            @DefaultValue("NONE") @QueryParam("appId") String appId,
            @DefaultValue("NONE") @QueryParam("level") String level) {

        List<LogMessage> logMessages = new ArrayList<>();

        logMessages = DatabaseManager.getInstance().getLogMessages(appId, level);

        Gson gson = new Gson();

        String res = gson.toJson(logMessages);

        return Response
                .ok(res)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Headers",
                        "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Methods",
                        "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addLogMessage(String message) {
        Gson gson = new Gson();
        LogMessage logMessage = gson.fromJson(message, LogMessage.class);
        int rows = DatabaseManager.getInstance().addLogMessage(logMessage);

        return Response.ok().build();
    }
}
