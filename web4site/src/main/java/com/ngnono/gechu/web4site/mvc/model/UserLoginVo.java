package com.ngnono.gechu.web4site.mvc.model;

import javax.validation.constraints.Size;

/**
 * Created by ngnono on 14-2-12.
 */
public class UserLoginVo {


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 用户名
     *
     * */
    @Size (min=6, max=20, message="用户名长度只能在6-20之间")
    private String username;

    /**
     * 密码
     */
    @Size(min=6, max=20, message="密码长度只能在6-20之间")
    private String password;
}
