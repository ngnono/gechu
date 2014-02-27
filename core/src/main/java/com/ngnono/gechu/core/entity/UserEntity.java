package com.ngnono.gechu.core.entity;

import java.util.List;

/**
 * Created by ngnono on 14-1-27.
 */
public class UserEntity extends StdBaseEntity {

    private int Id;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String username;
    private String password;

    /**
     * roles
     */
    private List<RoleEntity> roles;

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
