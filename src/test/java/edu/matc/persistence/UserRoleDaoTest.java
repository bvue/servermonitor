package edu.matc.persistence;

import edu.matc.entity.User;
import edu.matc.entity.UserRole;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.testng.annotations.Test;

import java.util.List;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.*;

/**
 * Created by bvue0 on 12/4/2016.
 */
public class UserRoleDaoTest {

    UserRoleDao dao = new UserRoleDao();
    private Logger logger = org.apache.log4j.Logger.getLogger(this.getClass());

    @Test
    public void testGetAllUsersFromRoleTable() throws Exception {
        List<UserRole> users = dao.getAllUsersFromRoleTable();
        logger.info(users);
        assertTrue(users.size() > 0);
    }

    @Test
    public void testAddUserRole() throws Exception {
        UserRole userRole = new UserRole();
        userRole.setUserName("myTestUser");
        userRole.setRoleName("employee");

        dao.addUserRole(userRole.getUserName());
    }

    @Test
    public void testDeleteUser() throws Exception {
        UserRole user = dao.deleteUserFromRoleTable(52);
        assertNull(user);
    }
}