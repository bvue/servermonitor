package edu.matc.entity;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

/**
 * Created by bvue0 on 12/14/2016.
 */
public class SecondServerTest {
    SecondServer secondServer = new SecondServer();

    @Test
    public void testGetMemoryUsage() throws Exception {
        List<String> testString;
        testString = secondServer.getMemoryUsage();
        assertNotNull(testString);
    }

    @Test
    public void testGetSpecificService() throws Exception {
        List<String> testString;
        testString = secondServer.getSpecificService();
        assertNotNull(testString);
    }

}