package org.ngnono.gechu.core.entity;

import java.util.List;

/**
 * Created by ngnono on 14-1-27.
 */
public class RoleEntity extends StdBaseEntity{

    public List<PermissionEntity> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionEntity> permissions) {
        this.permissions = permissions;
    }

    private List<PermissionEntity> permissions;

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
