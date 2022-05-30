package com.uriasluis.workshopmongo.services.exception;

import java.io.Serializable;

public class StandardError implements Serializable {

    private static final long serialVersioUID = 1L ;

    private Long Timestamp ;
    private Integer status ;
    private String error ;
    private String message ;
    private String path ;

    public StandardError(){}

    public StandardError(Long timestamp, Integer status, String error, String message, String path) {
        Timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public Long getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(Long timestamp) {
        Timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
