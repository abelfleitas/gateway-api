package com.abelfleitas.api.exceptions.base_exceptions;

public class CustomBaseException extends Exception {
    
    protected int httpCode;
    protected int customCode;
    protected String customMessage;

    public CustomBaseException() {
        super();
    }

    public CustomBaseException(String message) {
        super(message);
    }

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }

    public int getCustomCode() {
        return customCode;
    }

    public void setCustomCode(int customCode) {
        this.customCode = customCode;
    }

    public String getCustomMessage() {
        return customMessage;
    }

    public void setCustomMessage(String customMessage) {
        this.customMessage = customMessage;
    }      
}
