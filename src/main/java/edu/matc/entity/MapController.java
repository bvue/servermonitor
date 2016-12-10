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

    private String nullServices;
    private String nullMemoryValue;
    private List<String> myServiceList;
    private List<String> memoryUsage;
    private ArrayList<String> prettyServiceList = new ArrayList<>();

    public void init() throws ServletException {}

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
        ServerConnection serverConnection2 = new ServerConnection();
        myServiceList = serverConnection.getAllServices();
        memoryUsage = serverConnection2.getMemoryUsage();



        if (memoryUsage != null) {
            String test;
            memoryUsage.get(0);
            memoryUsage.get(1);

            test = memoryUsage.get(0) + memoryUsage.get(1);
            request.setAttribute("memory", test);

        } else {
            nullMemoryValue= "Unable to retrieve memory usage.";
            request.setAttribute("memory", nullMemoryValue);
        }



        if (myServiceList != null) {
            request.setAttribute("serviceList", myServiceList);

        } else {
            nullServices= "Unable to retrieve tasks from server.";
            request.setAttribute("serviceList", nullServices);
        }

        request.getRequestDispatcher("/admin.jsp").forward(request, response);

    }

}
