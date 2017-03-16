package core.admin.pro.util;

import java.io.Serializable;

public class ManagerUserInfo implements Serializable{
    private static final long serialVersionUID = -427774639033430428L;

    private String userID;
    private String newToken;
    private String user_id;
    private String username;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getNewToken() {
        return newToken;
    }

    public void setNewToken(String newToken) {
        this.newToken = newToken;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
