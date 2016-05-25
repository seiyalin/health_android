package com.example.misssea.new_health;

import android.app.Application;

/**
 * Created by misssea on 2016/4/16.
 */
public class applicationTrans extends Application{
    private String name;
    private String userID;

    public String get_Name() {
        return name;
    }
    public String get_userID() {
        return userID;
    }

    public void setValue(String name,String userID) {
        this.name = name;
        this.userID=userID;
    }
}
