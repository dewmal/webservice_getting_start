package lk.ijse.webservice.resource_access.modal;

import java.util.Date;

public class Message {

    private String title;
    private String message;
    private Date dateTime;

    public Message() {
    }

    public Message(String title, String message, Date dateTime) {
        this.title = title;
        this.message = message;
        this.dateTime = dateTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
                "title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
