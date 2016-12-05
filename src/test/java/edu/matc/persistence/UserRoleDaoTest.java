package edu.matc.persistence;

import edu.matc.entity.UserRole;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.testng.annotations.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.*;

/**
 * Created by bvue0 on 12/4/2016.
 */
public class UserRoleDaoTest {

    UserRoleDao dao;
    private Logger logger = org.apache.log4j.Logger.getLogger(this.getClass());

    @Before
    public void setup() {
        dao = new UserRoleDao();
    }

    @Test
    public void testGetAllUsersFromRoleTable() throws Exception {
        List<UserRole> users = dao.getAllUsersFromRoleTable();
        //logger.info(users);
        assertTrue(users.size() > 0);
    }

    @Test
    public void testAddUserRole() throws Exception {
        UserDao dao = new UserDao();
        UserRole userRole = new UserRole();
        userRole.setUserName("myTestUserRoleName");
        userRole.setRoleName("employee");
        //assertEquals("These match: ", "myTestUserRoleName", userRole.getUserName());
    }

}