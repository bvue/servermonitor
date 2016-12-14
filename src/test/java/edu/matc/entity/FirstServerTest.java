package edu.matc.entity;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

/**
 * Created by bvue0 on 12/14/2016.
 */
public class FirstServerTest {
    FirstServer firstServer = new FirstServer();

    @Test
    public void testGetMemoryUsage() throws Exception {
        List<String> testString;
        testString = firstServer.getMemoryUsage();
        assertNotNull(testString);
    }

    @Test
    public void testGetAllServices() throws Exception {
        List<String> testString;
        testString = firstServer.getAllServices();
        assertNotNull(testString);
    }

}