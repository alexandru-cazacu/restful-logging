/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import logging.model.DatabaseManager;
import logging.model.LogMessage;
import logging.model.LogMessageDB;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alex
 */
public class DatabaseManagerTest {

    @Test
    public void testGetInstance() {
        LogMessageDB expResult = DatabaseManager.getInstance();
        LogMessageDB result = DatabaseManager.getInstance();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetLogMessages() {
        String appId = "NONE";
        String level = "INFO";
        List<LogMessage> result = DatabaseManager.getInstance().getLogMessages(appId, level);
        assertEquals("INFO", result.get(0).getLevel());
    }

    @Test
    public void testAddLogMessage() {
        fail("Test not implemented.");
    }
}
