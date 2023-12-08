package com.streaming.model;

import java.util.Date;
import java.util.List;

/**
 * @author Albert Gomes Cabral
 */
public class NotificationNewsStreamingModel {

    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        this._createDate = createDate;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        this._description = description;
    }

    public List<String[]> getMessage() {
        return _message;
    }

    public void setMessage(List<String[]> message) {
        this._message = message;
    }

    public long getNewsId() {
        return _newsId;
    }

    public void setNewsId(long newsId) {
        this._newsId = newsId;
    }

    public long getNotificationNewsStreamingId() {
        return _notificationId;
    }

    public long getNotificationNewsStreamingId(
            long notificationNewsEbookIdParam) {
       if (notificationNewsEbookIdParam != _notificationId) {
            return -1;
        }
        return _notificationId;
    }

    public void setNotificationNewsEbookId(
            long notificationNewsEbookId) {
        this._notificationId = notificationNewsEbookId;
    }

    public void setUserId(long userId) {
        this._userId = userId;
    }

    public long getUserId() {
        return _userId;
    }

    public String getSender() {
        return _sender;
    }

    public void setSender(String sender) {
        this._sender = sender;
    }

    public String getStatusNotification() {
        return _statusNotification;
    }

    public void setStatusNotification(String statusNotification) {
        this._statusNotification = statusNotification;
    }

    private Date _createDate;

    private String _description;

    private List<String[]> _message;

    private long _notificationId;

    private long _userId;

    private long _newsId;

    private String _sender;

    private String _statusNotification;

}