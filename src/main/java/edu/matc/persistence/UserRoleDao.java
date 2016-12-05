package edu.matc.persistence;

import edu.matc.entity.UserRole;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;


/**
 * Created by bvue0 on 12/4/2016.
 */
public class UserRoleDao {
    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all users from the role table
     *
     * @return All users from role table
     */
    public List<UserRole> getAllUsersFromRoleTable() {
        List<UserRole> users;
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        users = session.createCriteria(UserRole.class).list();
        log.info(users);
        return users;
    }


    /**
     * add a user role
     *
     * @param user
     * @return the id of the inserted record
     */
    public String addUserRole(String user) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            UserRole userRole = new UserRole(user, "employee");
            tx.commit();
            log.info("Added user name: " + user + " with role of: " + userRole.getRoleName());
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            log.error(e);
        } finally {
            session.close();
        }
        return user;
    }


}
