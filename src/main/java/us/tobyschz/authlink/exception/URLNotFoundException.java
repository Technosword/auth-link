package us.tobyschz.authlink.exception;

public class URLNotFoundException extends Exception {
    public URLNotFoundException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
