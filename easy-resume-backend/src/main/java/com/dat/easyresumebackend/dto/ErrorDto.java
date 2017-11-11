package com.dat.easyresumebackend.dto;

/**
 * Created by Pham Tien Dat on 05/11/2017.
 */
public class ErrorDto {
    private String exception;
    private String message;

    public ErrorDto() {
    }

    public ErrorDto(String exception, String message) {
        this.exception = exception;
        this.message = message;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
