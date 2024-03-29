/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logging.controller;

import logging.model.DatabaseManager;
import logging.model.LogMessage;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import logging.client.LoggerSender;
import logging.model.Settings;

/**
 *
 * @author Alexandru Cazacu
 */
@Path("logmessages")
public class LogMessageResource {

    /**
     * Get a Response containin a set of Settings.
     * @return Response containing a set of Settings.
     */
    @GET
    @Path("settings")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLogMessagesToLog() {
        
        Settings.getInstance().loggableLevels.add("SEVERE");
        Settings.getInstance().loggableLevels.add("WARNING");

        Gson gson = new Gson();

        String res = gson.toJson(Settings.getInstance());
        
        LoggerSender.getInstance().info(res);

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

    /**
     * Get a Response containing a list of LogMessages.
     * @param appId appId
     * @param level level
     * @return LogMessages Response containing a list of LogMessages.
     */
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

    /**
     * Post a new LogMessage.
     * @param message
     * @return Response
     */
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
