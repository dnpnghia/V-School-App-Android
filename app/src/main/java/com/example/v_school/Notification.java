package com.example.v_school;



import java.util.ArrayList;


public class Notification {
    private int id;
    private String idFrom;
    private String idTo;
    private String topic;
    private String message;
    private String day;
    private int isRead;


    public Notification(int id, String idFrom, String idTo, String topic, String message, String day) {
        this.id = id;
        this.idFrom = idFrom;
        this.idTo = idTo;
        this.topic = topic;
        this.message = message;
        this.day = day;
    }

    public Notification() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getIdFrom() {
        return idFrom;
    }

    public void setIdFrom(String idFrom) {
        this.idFrom = idFrom;
    }

    public String getIdTo() {
        return idTo;
    }

    public void setIdTo(String idTo) {
        this.idTo = idTo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getIsRead() {
        return isRead;
    }

    public void setIsRead(int isRead) {
        this.isRead = isRead;
    }
}
