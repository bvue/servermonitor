package edu.matc.persistence;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import edu.matc.entity.*;
import org.apache.log4j.Logger;

/**
 * Created by bvue0 on 12/2/2016.
 */


@WebServlet(name = "RegisterUser", urlPatterns = { "/registerUser" } )

public class RegisterUser extends HttpServlet{
    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User(0, req.getParameter("firstName"), req
                .getParameter("lastName"), req.getParameter("userName"),
                req.getParameter("password1"));
        log.debug("Adding User: " + user);
        UserDao dao = new UserDao();
        dao.addUser(user);
    }
}
