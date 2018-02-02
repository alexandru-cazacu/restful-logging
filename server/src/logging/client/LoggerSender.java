/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logging.client;

import java.util.logging.*;

/**
 *
 * @author Alex
 */
public class LoggerSender {

    private static Logger logger = null;
    
    private LoggerSender() {
        
    }
    
    public static Logger getInstance() {
        if (logger == null)
            logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        return logger;
    }

    public static void setUp() {
        Handler handler = new LoggerHandler();
        handler.setFormatter(new SimpleFormatter());
        getInstance().addHandler(handler);
    }
}
