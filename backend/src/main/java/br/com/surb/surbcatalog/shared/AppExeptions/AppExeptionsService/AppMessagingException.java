package br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService;

public class AppMessagingException extends RuntimeException {
    public AppMessagingException(String msg) {
        super(msg);
    }

    public AppMessagingException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppMessagingException(Throwable cause) {
        super(cause);
    }

    protected AppMessagingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
