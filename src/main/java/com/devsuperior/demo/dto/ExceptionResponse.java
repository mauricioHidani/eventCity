package com.devsuperior.demo.dto;

import java.time.Instant;

public class ExceptionResponse {

    private Instant timestamp;
    private Integer status;
    private String error;
    private String path;

    public ExceptionResponse(Instant timestamp, Integer status, String error, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.path = path;
    }

    public ExceptionResponse(ExceptionResponseBuilder builder) {
        this.timestamp = builder.timestamp;
        this.status = builder.status;
        this.error = builder.error;
        this.path = builder.path;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getPath() {
        return path;
    }

    public static ExceptionResponseBuilder builder() {
        return new ExceptionResponseBuilder();
    }

    public static class ExceptionResponseBuilder {
        private Instant timestamp;
        private Integer status;
        private String error;
        private String path;

        public ExceptionResponseBuilder timestamp(Instant timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public ExceptionResponseBuilder status(Integer status) {
            this.status = status;
            return this;
        }

        public ExceptionResponseBuilder error(String error) {
            this.error = error;
            return this;
        }

        public ExceptionResponseBuilder path(String path) {
            this.path = path;
            return this;
        }

        public ExceptionResponse build() {
            return new ExceptionResponse(this);
        }
    }
}
