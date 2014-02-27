package com.ngnono.gechu.core.shiro;

import org.apache.shiro.session.Session;
import org.springframework.data.annotation.TypeAlias;

import java.io.Serializable;

/**
 * Created by ngnono on 14-2-25.
 */
@TypeAlias("session")
public class GechuSession {
    public Serializable getId() {
        return id;
    }

    public void setId(Serializable id) {
        this.id = id;
    }

    private Serializable id;

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    private Session session;


}
