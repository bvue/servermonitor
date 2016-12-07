package edu.matc.entity;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet(name = "MapController", urlPatterns = { "/mapcontroller" })

public class MapController extends HttpServlet{

    private final Logger logger = Logger.getLogger(this.getClass());
    String tasks;
    String nullTasks;
    List<String> myTaskList;

    public void init() throws ServletException {

    }

    /**
    public void getRunningTasks(String myList) {

        if (myList != null) {
            tasks = myList;
            //logger.info("Here are the tasks in the Map Controller class: " + tasks);
        } else {
            tasks = "Unable to retrieve tasks from server.";
        }

    }
     */


    /**
     *  Handles HTTP GET requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServerConnection serverConnection = new ServerConnection();
        myTaskList = serverConnection.getTaskList();
        //logger.info("Here are the tasks in the Map Controller class: " + myTaskList);

        if (myTaskList != null) {
            for (String taskString : myTaskList) {
                request.setAttribute("taskList", taskString);
                logger.info("Here are the tasks in the Map Controller class: " + taskString);
            }
        } else {
            nullTasks = "Unable to retrieve tasks from server.";
            request.setAttribute("taskList", nullTasks);
        }

        request.setAttribute("test", "my test message will work!");

        String url = "admin.jsp";

        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

}
