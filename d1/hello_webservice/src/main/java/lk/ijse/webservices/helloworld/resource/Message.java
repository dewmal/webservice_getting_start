package lk.ijse.webservices.helloworld.resource;

import java.util.Date;

public class Message {
    private String message;
    private String title;
    private Date dateTime;

    public Message() {
    }

    public Message(String title,String message,  Date dateTime) {
        this.message = message;
        this.title = title;
        this.dateTime = dateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                ", title='" + title + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
