package net.plugins.model;

/**
 * Created by Administrator on 2017/7/21.
 * IntelliJ IDEA 2017 of gzcss
 */

import java.io.Serializable;
import java.util.List;
import java.util.UUID;


public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private int user_id;

    private String user_name;

    private String password;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    private String fullname;


}
