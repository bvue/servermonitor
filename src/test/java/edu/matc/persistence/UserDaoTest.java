package edu.matc.persistence;

import edu.matc.entity.UserRole;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import edu.matc.entity.User;

import java.util.List;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by bvue0
 */
public class UserDaoTest {

    UserDao dao;
    private Logger logger = org.apache.log4j.Logger.getLogger(this.getClass());

    @Before
    public void setup() {
        dao = new UserDao();
    }

    @Test
    public void getAllUsers() throws Exception {
        List<User> users = dao.getAllUsers();
        logger.info(users);
        assertTrue(users.size() > 0);
    }


    @Test
    public void getUser() throws Exception {
        //User user = dao.getUser(1);
        //String expectedUserValue = "wrong";
        //This WILL fail but I want to see if it grabs the correct user
        //assertEquals("Request: ", expectedUserValue, user);
    }

    @Test
    public void addUser() throws Exception {
        UserDao dao = new UserDao();
        int insertedUserId = 0;
        //create user to add
        User user = new User();
        user.setFirstName("test");
        user.setLastName("test");
        user.setUserid("test");
        user.setPassword("test");

        insertedUserId = dao.addUser(user);

        assertTrue(insertedUserId > 0);
        dao.deleteUser(user.getPersonid());
    }


    @Test
    public void deleteUser() throws Exception {
        User user = dao.deleteUser(5);
        assertNull(user);
    }

    @Test
    public void updateUser() throws Exception {
        //User user = dao.updateUser();


    }


}
