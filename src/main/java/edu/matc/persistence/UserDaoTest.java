package edu.matc.persistence;

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

    @Before
    public void setup() {
        dao = new UserDao();
    }

    @Test
    public void getAllUsers() throws Exception {
        List<User> users = dao.getAllUsers();
        assertTrue(users.size() > 0);
    }

    @Test
    public void getUser() throws Exception {
        User user = dao.getUser(1);
        String expectedUserValue = "This is the wrong value. Show me the correct value.";
        //This WILL fail but I want to see if it grabs the correct user
        assertEquals("Request: ", expectedUserValue, user);
    }

    @Test
    public void addUser() throws Exception {
        //User user = dao.addUser();
    }

    @Test
    public void deleteUser() throws Exception {
        User user = dao.deleteUser(1);
        assertNull(user);
    }

    @Test
    public void updateUser() throws Exception {
        //User user = dao.updateUser();


    }


}
