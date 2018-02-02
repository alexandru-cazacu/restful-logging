/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logging.client;

import logging.model.LogMessage;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import logging.model.DatabaseManager;

/**
 *
 * @author Alex
 */
public class LoggerHandler extends Handler {

    @Override
    public void publish(LogRecord record) {

        LogMessage log = new LogMessage("qwertyuiop", record.getMessage(), record.getLevel().toString());

        DatabaseManager.getInstance().addLogMessage(log);
    }

    @Override
    public void flush() {
        LoggerSender.getInstance().severe("Unsupported method was called.");
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void close() throws SecurityException {
        LoggerSender.getInstance().severe("Unsupported method was called.");
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
