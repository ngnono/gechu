package com.ngnono.gechu.core.entity;

/**
 * Created by ngnono on 14-1-27.
 */
public class ResourceEntity extends StdBaseEntity {
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

    private int id;
    private String name;
}
