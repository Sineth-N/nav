package com.d2s2.sinethn.nav;

import java.io.Serializable;

/**
 * Created by Sineth on 10/7/2015.
 */
public class TaskNotify implements Serializable {
    public String name;
    public String title;
    public String description;
    public String time;
    public String date;
    public String type;
    public String priority;

    public String getName() {
        return name;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
