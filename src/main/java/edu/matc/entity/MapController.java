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

    String nullServices;
    List<String> myServiceList;

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
        myServiceList = serverConnection.getAllServices();


        if (myServiceList != null) {
            request.setAttribute("serviceList", myServiceList);
        } else {
            nullServices= "Unable to retrieve tasks from server.";
            request.setAttribute("taskList", nullServices);
        }

        request.getRequestDispatcher("/admin.jsp").forward(request, response);
    }

}
