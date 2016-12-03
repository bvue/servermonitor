package edu.matc.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


/**
 * A class to represent a user.
 *
 * @author bvue
 */
@Entity
@Table(name = "operdefn")
public class User {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private int personid;

    private String firstName;

    private String lastName;

    @Column(name = "user_name")
    private String userid;

    private String password;

    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param personid    the person's ID number
     * @param firstName   the first name
     * @param lastName    the last name
     * @param userid      the userid
     * @param password    password
     */
    public User(int personid, String firstName, String lastName, String userid, String password) {
        this.personid = personid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userid = userid;
        this.password = password;
    }


    /**
     * Gets person's ID #
     *
     * @return the person ID
     */
    public int getPersonid() {
        return personid;
    }


    /**
     * Sets the person ID
     *
     * @param personid
     */
    public void setPersonid(int personid) {
        this.personid = personid;
    }


    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets userid.
     *
     * @return the userid
     */
    public String getUserid() {
        return userid;
    }

    /**
     * Sets userid.
     *
     * @param userid the userid
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }


    /**
     * Gets password
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }


    /**
     * Sets password
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "Person ID #='" + personid + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userid='" + userid + '\'' +
                ", password=" + password +
                '}';
    }
}