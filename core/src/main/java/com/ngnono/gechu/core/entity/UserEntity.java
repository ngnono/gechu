package com.ngnono.gechu.core.entity;

import java.util.List;

/**
 * Created by ngnono on 14-1-27.
 */
public class UserEntity extends StdBaseEntity {

    private int Id;
    private String userName;
    private String password;

    /**
     * roles
     */
    private List<RoleEntity> roles;

    public UserEntity(String userName, String password, int id) {
        this.userName = userName;
        this.password = password;
        Id = id;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }

}
