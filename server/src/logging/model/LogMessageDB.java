/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logging.model;

import java.util.List;

/**
 *
 * @author alex
 */
public interface LogMessageDB {
    /**
     * Returns a filtered List of LogMessage from the Database.
     * @param appid appId
     * @param level level
     * @return filtered List of LogMessage.
     */
    public List<LogMessage> getLogMessages(String appid, String level);
    /**
     * Adds a new LogMessage to the Database.
     * @param logMessage LogMessage to add.
     * @return Affected rows.
     */
    public int addLogMessage(LogMessage logMessage);
    /**
     * Returns current Setting from the Database.
     * @return current Settings.
     */
    public Settings getSettings();
}
