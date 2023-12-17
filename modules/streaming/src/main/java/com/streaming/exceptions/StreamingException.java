package com.streaming.exceptions;

/**
 * @author Albert Gomes Cabral
 */
public class StreamingException extends RuntimeException {
    public StreamingException(String message, Exception exception) {
        super(message, exception);
    }

    public StreamingException(String s) {
    }

    public static class StreamingExceptionAllowedDenied {
        private StreamingExceptionAllowedDenied(Exception exception)
                throws StreamingException {
            throw new StreamingException(
                    "Allowed denied to restrict area application, try again.", exception);
        }
    }

    public static class StreamingExceptionContentNotFound extends Throwable {
        public StreamingExceptionContentNotFound()
                throws StreamingException {
            throw new StreamingException(
                    "Requested contend didn't was founded. Try again.");
        }
    }

    public static class StreamingExceptionPreferencesPortletFailure {
        private StreamingExceptionPreferencesPortletFailure()
                throws StreamingException {
            throw new StreamingException(
                    "Unable to get Preferences Streaming Portlet. Try again.");
        }
    }
}
