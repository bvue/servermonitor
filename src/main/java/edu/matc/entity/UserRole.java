package edu.matc.entity;

import javax.persistence.*;


/**
 * Created by bvue0 on 12/4/2016.
 */
@Entity
@Table(name = "user_roles")
public class UserRole {

    @Column(name="user_name")
    private String userName;

    @Column(name="role_name")
    private String roleName;


    public UserRole() {

    }

    /**
     * Instantiates a new User Role.
     *
     * @param userName    the person's user name
     * @param roleName   the person's user role
     */
    public UserRole(String userName, String roleName) {
        this.userName = userName;
        this.roleName = roleName;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }


    @Override
    public String toString() {
        return "User Role{" +
                "User Name='" + userName + '\'' +
                ", Role Name='" + roleName + '\'' +
                '}';
    }
}
