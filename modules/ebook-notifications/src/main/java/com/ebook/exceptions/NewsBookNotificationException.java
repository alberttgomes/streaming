package com.ebook.exceptions;

/**
 * @author Albert Gomes Cabral
 */
public class NewsBookNotificationException extends Throwable {
    public NewsBookNotificationException(String message) {
        super(message);
    }

    public NewsBookNotificationException(String message, Throwable throwable){
        super(message, throwable);
    }
}