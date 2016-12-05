package edu.matc.entity;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet(name = "MapController", urlPatterns = { "/mapcontroller" })

public class MapController {

    private final Logger logger = Logger.getLogger(this.getClass());
    String tasks = "these are my tasks: ;sodfhoshnv lskdflsdfl osdjvskldlv";

    public void init() throws ServletException {

    }

    /**
    public void getRunningTasks(String myList) {
        tasks = myList;
        logger.info(myList);
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

        //map tasks onto the JSP page
        request.setAttribute("taskList", tasks);

        String url = "/admin.jsp";

        request.getRequestDispatcher(url).forward(request, response);

    }

}
