/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test1_client;

import com.mycompany.test1_server.Event;
import com.mycompany.test1_server.Manager;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author studente
 */
public class TEST1_Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String res = TEST1_Client.getEvents();
        System.out.println(res.replace("*", "\n"));
        
        Event event = TEST1_Client.getEvent(0);
        System.out.println(event.getId() + ", " + event.getName() + ", " + event.getDate() + ", " + event.getManagerID());
        
        Manager manager = TEST1_Client.getManager(event.getManagerID());
        System.out.println("Event " + event.getId() + " managed by " + manager.getSurname() + " " + manager.getName());
    }

    private static String getEvents() {
        com.mycompany.test1_server.WSImplService service = new com.mycompany.test1_server.WSImplService();
        com.mycompany.test1_server.WSInterface port = service.getWSImplPort();
        return port.getEvents();
    }

    private static Event getEvent(java.lang.Integer arg0) {
        com.mycompany.test1_server.WSImplService service = new com.mycompany.test1_server.WSImplService();
        com.mycompany.test1_server.WSInterface port = service.getWSImplPort();
        return port.getEvent(arg0);
    }

    private static Manager getManager(java.lang.Integer arg0) {
        com.mycompany.test1_server.WSImplService service = new com.mycompany.test1_server.WSImplService();
        com.mycompany.test1_server.WSInterface port = service.getWSImplPort();
        return port.getManager(arg0);
    }

}
