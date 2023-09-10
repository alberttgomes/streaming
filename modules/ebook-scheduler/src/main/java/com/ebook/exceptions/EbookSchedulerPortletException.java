package com.ebook.exceptions;

/**
 * @author Albert Gomes
 */
public class EbookSchedulerPortletException extends Throwable {
    public EbookSchedulerPortletException
            (String message) {
        super(message);
    }

    public EbookSchedulerPortletException
            (String message, Throwable throwable) {
        super(message, throwable);
    }
}
