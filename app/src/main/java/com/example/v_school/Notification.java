package com.example.v_school;



import com.google.firebase.database.IgnoreExtraProperties;


@IgnoreExtraProperties
public class Notification {
    public int id;
    public String idFrom;
    public String idTo;
    public String topic;
    public String message;
    public String day;
    public int isRead;

    public Notification() {
    }

    public Notification(int id, String idFrom, String idTo, String topic, String message, String day, int isRead) {
        this.id = id;
        this.idFrom = idFrom;
        this.idTo = idTo;
        this.topic = topic;
        this.message = message;
        this.day = day;
        this.isRead = isRead;
    }

    public Notification(String idFrom, String idTo, String topic, String message, String day) {
        this.idFrom = idFrom;
        this.idTo = idTo;
        this.topic = topic;
        this.message = message;
        this.day = day;
    }

    public Notification(String idFrom, String idTo, String topic, String message, String day, int isRead) {
        this.idFrom = idFrom;
        this.idTo = idTo;
        this.topic = topic;
        this.message = message;
        this.day = day;
        this.isRead = isRead;
    }

    public Notification(int id, String idFrom, String idTo, String topic, String message, String day) {
        this.id = id;
        this.idFrom = idFrom;
        this.idTo = idTo;
        this.topic = topic;
        this.message = message;
        this.day = day;
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

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", idFrom='" + idFrom + '\'' +
                ", idTo='" + idTo + '\'' +
                ", topic='" + topic + '\'' +
                ", message='" + message + '\'' +
                ", day='" + day + '\'' +
                ", isRead=" + isRead +
                '}';
    }
}
