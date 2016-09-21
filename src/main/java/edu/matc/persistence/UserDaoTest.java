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
        //TODO test the getUser Methods
    }

    @Test
    public void addUser() throws Exception {
        // TODO test the addUser Method
    }

    @Test
    public void deleteUser() throws Exception {
        //TODO test the delete
    }

    @Test
    public void updateUser() throws Exception {

        //TODO test the update

    }


}
