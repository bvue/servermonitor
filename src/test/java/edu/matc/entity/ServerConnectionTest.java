package edu.matc.entity;

import org.apache.log4j.Logger;
import org.junit.Test;
import static org.testng.Assert.*;

/**
 * Created by bvue0 on 11/29/2016.
 */
public class ServerConnectionTest {

    private final Logger logger = Logger.getLogger(this.getClass());
    ServerConnection serverConnection = new ServerConnection();

    @Test
    public void testGetTaskList() throws Exception {
        serverConnection.getTaskList();

    }







}