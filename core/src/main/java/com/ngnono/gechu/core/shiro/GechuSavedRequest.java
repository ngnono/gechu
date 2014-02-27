package com.ngnono.gechu.core.shiro;

import java.io.Serializable;

/**
 * Created by ngnono on 14-2-25.
 */
public class GechuSavedRequest implements Serializable {
    private String method;
    private String queryString;
    private String requestURI;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getRequestURI() {
        return requestURI;
    }

    public void setRequestURI(String requestURI) {
        this.requestURI = requestURI;
    }
}
