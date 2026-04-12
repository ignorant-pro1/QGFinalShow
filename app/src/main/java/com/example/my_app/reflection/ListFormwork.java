package com.example.my_app.reflection;

import java.util.List;

public class ListFormwork {
    private String title;
    private String rDate;
    private boolean isCompleted;

    public ListFormwork(String title,String r_date){
        this.title = title;
        this.rDate = rDate;
        this.isCompleted = false;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public String getrDate() {
        return rDate;
    }

    public void setrDate(String rDate) {
        this.rDate = rDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
