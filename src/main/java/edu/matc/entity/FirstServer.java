package edu.matc.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bvue0 on 11/11/2016.
 */
public class FirstServer {
    private ServerConnection newServerConnection = new ServerConnection();
    private List<String> result = new ArrayList<String>();
    private String host = "67.205.162.127";


    public List getMemoryUsage() {

        result = newServerConnection.run("free -m", host);
        return result;
    }


    public List getAllServices() {

        result = newServerConnection.run("service --status-all", host);
        return result;

    }
}
