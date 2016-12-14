package edu.matc.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * This class instantiates the ServerConnection class and gets the memory and service list from the first
 * server.
 *
 * @author Bao Vue
 */
public class FirstServer {
    private ServerConnection newServerConnection = new ServerConnection();
    private List<String> result = new ArrayList<String>();
    private String host = "67.205.162.127";


    /**
     * This runs a command on the server to get the memory usage
     *
     * @return result the memory usage
     */
    public List getMemoryUsage() {

        result = newServerConnection.run("free -m", host);
        return result;
    }


    /**
     * This runs a command on the server to get the service list
     *
     * @return result the service list
     */
    public List getAllServices() {

        result = newServerConnection.run("service --status-all", host);
        return result;

    }
}
