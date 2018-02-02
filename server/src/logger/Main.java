/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logger;

import java.util.logging.LogRecord;
import java.util.logging.Logger;
import logging.controller.LogMessageWebService;
import logging.client.LoggerSender;

/**
 *
 * @author alex
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        LoggerSender.setUp();
        
        LogMessageWebService webService = new LogMessageWebService();
        webService.start();
    }
}