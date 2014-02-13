package com.ngnono.gechu.core.entity;

/**
 * Created by ngnono on 14-1-27.
 */
public class RolePermissionRelationEntity extends StdBaseEntity {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public int getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(int permissionid) {
        this.permissionid = permissionid;
    }

    private int id;
    private int roleid;
    private int permissionid;

}
