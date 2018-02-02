/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logging.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex
 */
public class Settings {

    private static Settings instance;
    public ArrayList<String> loggableLevels;
    public int newRequestIntervalInSeconds;

    private Settings() {
        loggableLevels = new ArrayList<>();
        newRequestIntervalInSeconds = 10;
    }

    public static Settings getInstance() {
        if (instance == null) {
            instance = new Settings();
        }
        return instance;
    }
}
