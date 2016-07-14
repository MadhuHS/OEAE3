package com.jspiders.moblie.studentsinfoapp;

import io.realm.RealmObject;

/**
 * Created by user on 14/07/2016.
 */
public class Student extends RealmObject {

    private int ID;
    private String name;
    private String branch;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}
