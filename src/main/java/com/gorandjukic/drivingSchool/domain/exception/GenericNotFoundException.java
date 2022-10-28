package com.gorandjukic.drivingSchool.domain.exception;

public class GenericNotFoundException extends RuntimeException {

    private final String message;

    public GenericNotFoundException(String message) {
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
