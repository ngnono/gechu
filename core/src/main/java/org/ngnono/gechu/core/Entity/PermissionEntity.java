package org.ngnono.gechu.core.entity;

/**
 * Created by ngnono on 14-1-27.
 */
public class PermissionEntity extends StdBaseEntity {
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    private int Id;
    private String Name;
}
