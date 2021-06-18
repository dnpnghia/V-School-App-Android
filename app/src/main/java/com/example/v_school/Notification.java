package com.example.v_school;

import java.util.ArrayList;

public class Notification {
    private String idFrom;
    private String idTo;
    private String message;
    private String day;

    public Notification(String idFrom, String idTo, String message, String day) {
        this.idFrom = idFrom;
        this.idTo = idTo;
        this.message = message;
        this.day = day;
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
}
