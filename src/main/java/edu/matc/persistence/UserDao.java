package edu.matc.persistence;


import edu.matc.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bvue0
 */
public class UserDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all users
     *
     * @return All users
     */
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        users = session.createCriteria(User.class).list();
        return users;
    }

    /** Get a single user for the given id
     *
     * @param id user's id
     * @return User
     */
    public User getUser(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        User user = (User) session.get(User.class, id);
        return user;
    }

    /** Retrieve users by lastname
     *
     * @param lastName User's last name which is the search criteria
     * @return User
     */
    public List<User> getUsersByLastName(String lastName) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("lastName", lastName));
        return criteria.list();

    }



    /**
     * add a user
     *
     * @param user
     * @return the id of the inserted record
     */
    public int addUser(User user) {
        //TODO add the user and return the id of the inserted user
        int id = 0;
        return id;
    }

    /**
     * delete a user by id
     * @param id the user's id
     */
    public void deleteUser(int id) {
        // TODO delete the user with the given id

    }

    /**
     * Update the user
     * @param user
     */

    public void updateUser(User user) {
        // TODO update the user

    }




}
