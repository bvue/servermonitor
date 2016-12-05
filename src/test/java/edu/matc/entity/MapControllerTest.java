package edu.matc.entity;

import com.sun.javafx.collections.MappingChange;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.util.List;

import static edu.matc.entity.ServerConnection.*;
import static org.testng.Assert.*;

/**
 * Created by bvue0 on 12/3/2016.
 */
public class MapControllerTest {
    @Test
    public void testGetRunningTasks() throws Exception {
        Logger logger = Logger.getLogger(this.getClass());
        List<String> myTestTaskList;

        ServerConnection serverConnection = new ServerConnection();
        myTestTaskList = serverConnection.getTaskList();

        logger.info("Task List from Server Connection Class: " + myTestTaskList);

        for (String runningTasks : myTestTaskList) {
            logger.info("Running Tasks: " + runningTasks);
            //MapController mapResultsToJsp = new MapController();
            //mapResultsToJsp.getRunningTasks(runningTasks);
        }
    }




}