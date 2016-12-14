package edu.matc.entity;


import edu.matc.util.Utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * This class instantiates the ServerConnection class and gets the memory usage and a specific service called "atd"
 * from the second server.
 *
 * @author Bao Vue
 */
public class SecondServer {

    private ServerConnection newServerConnection = new ServerConnection();
    private List<String> result = new ArrayList<String>();
    private String host = "104.236.104.28";

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
     * This runs a command on the server to get a specific service
     *
     * @return result the service list
     */
    public List getSpecificService() {

        result = newServerConnection.run("sudo service atd status", host);
        return result;

    }





}
