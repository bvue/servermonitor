package edu.matc.entity;

import org.apache.log4j.Logger;
import org.apache.log4j.net.SyslogAppender;

import java.io.*;
import java.util.*;
import javax.mail.MessagingException;
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
    private List<String> myServiceList2;
    private List<String> memoryUsage2;

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

        SendEmail errorEmail = new SendEmail();


        FirstServer getServicesFromFirstServer = new FirstServer();
        FirstServer getMemoryFromFirstServer = new FirstServer();
        myServiceList = getServicesFromFirstServer.getAllServices();
        memoryUsage = getMemoryFromFirstServer.getMemoryUsage();


        if (!memoryUsage.isEmpty()) {
            request.setAttribute("memory", memoryUsage);
        } else {
            nullMemoryValue= "Unable to retrieve memory usage.";
            request.setAttribute("memory", nullMemoryValue);
        }

        if (!myServiceList.isEmpty()) {
            request.setAttribute("serviceList", myServiceList);
            request.setAttribute("status", "ON");
        } else {
            nullServices= "Unable to retrieve tasks from server.";
            request.setAttribute("serviceList", nullServices);
            request.setAttribute("status", "OFF");
            try {
                errorEmail.run();
                logger.info("Email sent to inform user of server being down.");
                request.setAttribute("emailStatus", "Email sent to inform user of the server being.");
            } catch (MessagingException e) {
                logger.error("Error sending email: " + e);
                e.printStackTrace();
                request.setAttribute("emailStatus", "Unable to Send Email to User.");
            }
        }


        SecondServer getService = new SecondServer();
        SecondServer getMemory = new SecondServer();
        myServiceList2 = getService.getSpecificService();
        memoryUsage2 = getMemory.getMemoryUsage();


        if (!memoryUsage2.isEmpty()) {
            request.setAttribute("memory2", memoryUsage2);
        } else {
            nullMemoryValue= "Unable to retrieve memory usage.";
            request.setAttribute("memory2", nullMemoryValue);
        }


        if (!myServiceList2.isEmpty()) {
            request.setAttribute("serviceList2", myServiceList2);
            request.setAttribute("status2", "ON");
        } else {
            nullServices= "Unable to retrieve tasks from server.";
            request.setAttribute("serviceList2", nullServices);
            request.setAttribute("status2", "OFF");
            try {
                errorEmail.run();
                logger.info("Email sent to inform user of server being down.");
                request.setAttribute("emailStatus2", "Email sent to inform user of the server being down.");
            } catch (MessagingException e) {
                logger.error("Error sending email: " + e);
                e.printStackTrace();
                request.setAttribute("emailStatus2", "Unable to Send Email to User.");
            }
        }


        HttpSession session = request.getSession(true);
        String username = request.getRemoteUser();
        logger.info("USER LOGGED IN IS: " + username);
        request.setAttribute("user", username);


        request.getRequestDispatcher("/admin.jsp").forward(request, response);
    }
}
