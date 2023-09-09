package com.ebook.module;

import java.util.Date;
import java.util.List;

/**
 * @author Albert Gomes Cabral
 */
public class NotificationNewsEbookModel {
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String[]> getMessage() {
        return message;
    }

    public void setMessage(List<String[]> message) {
        this.message = message;
    }

    public long getNotificationNewsEbookId(long notificationNewsEbookId) {
        return notificationNewsEbookId;
    }

    public void setNotificationNewsEbookId(long notificationNewsEbookId) {
        this.notificationNewsEbookId = notificationNewsEbookId;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    private Date createDate;

    private String description;

    private List<String[]> message;

    private long notificationNewsEbookId;

    private String sender;

}