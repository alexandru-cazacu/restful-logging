/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook.model;

import java.sql.Timestamp;

/**
 *
 * @author Alexandru Cazacu
 */
public class LogMessage {
    private Timestamp timestamp;
    private String appid;
    private String message;

    public LogMessage(Timestamp timestamp, String appid, String message, String level) {
        this.timestamp = timestamp;
        this.appid = appid;
        this.message = message;
        this.level = level;
    }
    private String level;

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
