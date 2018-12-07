package com.poveda.training_bank.infrastructure.web.resources;


import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ErrorHandlerResult {

    private String uri;
    private final Errors errors;


    public ErrorHandlerResult(String uri){
        this();
        this.uri = uri;
    }

    public ErrorHandlerResult(){
        this.errors = new Errors();
    }

    public class Error{

        private final String message;
        private final int code;

        private Error(final String message, final int code){
            this.message = message;
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public int getCode() {
            return code;
        }

        @Override
        public boolean equals(final Object o){
            if(this == o)
                return true;
            if(o == null || getClass() != o.getClass())
                return false;
            final Error that = (Error) o;
            return Objects.equals(getCode(), that.getMessage()) && Objects.equals(getCode(), that.getMessage());
        }

        @Override
        public int hashCode(){
            return Objects.hash(getMessage(), getCode());
        }
    }

    public ErrorHandlerResult addErrors(final String message, final int code){
        this.errors.messages.add(new Error(message, code));
        return this;
    }

    public class Errors {
        private final List<Error> messages = new LinkedList<>();

        private Errors() {}

        public List<Error> getMessages() {
            return messages;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            final Errors that = (Errors) o;
            return Objects.equals(getMessages(), that.getMessages());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getMessages(), getMessages());
        }
    }

    @Override
    public boolean equals(final Object o){
        if(this == o)
            return true;
        if(o == null || getClass() != getClass())
            return false;
        final ErrorHandlerResult that = (ErrorHandlerResult) o;
        return  Objects.equals(getErrors(), that.getErrors()) && Objects.equals(getUri(), that.getUri());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getErrors(), getUri());
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Errors getErrors() {
        return errors;
    }
}
