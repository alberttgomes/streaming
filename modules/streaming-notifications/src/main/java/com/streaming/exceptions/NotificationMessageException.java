package com.ebook.exceptions;

/**
 * @author Albert Gomes Cabral
 */
public class NotificationMessageException extends Throwable {
    public NotificationMessageException(String message) {
        super(message);
    }

    public NotificationMessageException(
            String message, Throwable throwable){
        super(message, throwable);
    }
}