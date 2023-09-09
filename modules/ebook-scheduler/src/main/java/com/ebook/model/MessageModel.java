package com.ebook.model;

import com.liferay.portal.kernel.util.Time;

import java.util.Date;
import java.util.List;

/**
 * @author Albert Gomes
 */
public class MessageModel {
    private Date date;

    private String description;

    private List<String[]> message;

    private long messageId;

    private long userId;

    private Time time;

    private String timeZone;

    private String title;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}