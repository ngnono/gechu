package com.ngnono.gechu.core.entity;

import java.util.Date;

/**
 * Created by ngnono on 14-1-27.
 */
public abstract class StdBaseEntity extends BaseEntity {
    public Date getIndate() {
        return indate;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
    }

    public Date getUpdate() {
        return update;
    }

    public void setUpdate(Date update) {
        this.update = update;
    }

    public int getInuser() {
        return inuser;
    }

    public void setInuser(int inuser) {
        this.inuser = inuser;
    }

    public int getUpuser() {
        return upuser;
    }

    public void setUpuser(int upuser) {
        this.upuser = upuser;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private Date indate;
    private Date update;
    private int inuser;
    private int upuser;
    private int status;
}
