package edu.matc.entity;


import edu.matc.util.Utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by bvue0 on 11/11/2016.
 */
public class SecondServer {

    private ServerConnection newServerConnection = new ServerConnection();
    private List<String> result = new ArrayList<String>();
    private String host = "104.236.104.28";


    public List getMemoryUsage() {

        result = newServerConnection.run("free -m", host);
        return result;
    }


    public List getSpecificService() {

        result = newServerConnection.run("sudo service atd status", host);
        return result;

    }





}
