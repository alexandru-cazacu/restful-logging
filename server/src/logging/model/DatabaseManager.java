/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logging.model;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logging.client.LoggerSender;

/**
 *
 * @author alex
 */
public class DatabaseManager implements LogMessageDB {

    private Connection connection;
    private static LogMessageDB instance = null;

    private DatabaseManager() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Returns a static instance of DatabaseManager.
     * @return static instance of DatabaseManager.
     */
    public static LogMessageDB getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    /**
     * Checks if a Connection exists, if it doesn't it creates one.
     */
    private void checkConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost/logging", "root", "");
            }
            catch (SQLException ex) {
                ex.printStackTrace();
                System.exit(1);
            }
        }
    }

    @Override
    public List<LogMessage> getLogMessages(String appId, String level) {
        List<LogMessage> logMessages = new ArrayList();

        String query = "SELECT * FROM log WHERE 1=1";
        if (!appId.equals("NONE")) {
            query += " AND appId='" + appId + "'";
        }
        if (!level.equals("NONE")) {
            query += " AND level='" + level + "'";
        }
        System.out.println(appId + level);
        System.out.println(query);

        try {
            checkConnection();

            Statement s1 = (Statement) connection.createStatement();
            ResultSet r = s1.executeQuery(query);
            while (r.next()) {
                Timestamp resTimestamp = r.getTimestamp("timestamp");
                String resAppId = r.getString("appId");
                String resMessage = r.getString("message");
                String resLevel = r.getString("level");
                System.out.println(resTimestamp + resAppId + resMessage + resLevel);
                LogMessage lm = new LogMessage(resTimestamp, resAppId, resMessage, resLevel);
                logMessages.add(lm);
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
        return logMessages;
    }

    @Override
    public int addLogMessage(LogMessage logMessage) {

        String query = "INSERT INTO log (appId, message, level) VALUES (?, ?, ?)";

        try {
            checkConnection();

            PreparedStatement s1 = connection.prepareStatement(query);
            s1.setString(1, logMessage.getAppid());
            s1.setString(2, logMessage.getMessage());
            s1.setString(3, logMessage.getLevel());

            int rowCount = s1.executeUpdate();
            return rowCount;
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
        return 0;
    }

    @Override
    public Settings getSettings() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
