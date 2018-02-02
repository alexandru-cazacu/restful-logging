/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook;

import addressbook.controller.LogMessageWebService;

/**
 *
 * @author alex
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LogMessageWebService webService = new LogMessageWebService();
        webService.start();
    }
}
