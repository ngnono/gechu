package com.ngnono.gechu.core.entity;

/**
 * Created by ngnono on 14-1-27.
 */
public class UserRoleRelationEntity extends StdBaseEntity {
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    private int Id;
    private int userid;
    private int roleid;
}
