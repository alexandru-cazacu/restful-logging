/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook.model;

import java.util.List;

/**
 *
 * @author alex
 */
public interface LogMessageDB {
    public List<LogMessage> getLogMessages(String appid, String level);
    public int addLogMessage(LogMessage logMessage);
}
