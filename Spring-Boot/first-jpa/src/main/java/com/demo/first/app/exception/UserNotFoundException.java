package com.demo.first.app.exception;

// ham custom exception create kar rhe hai.... ye user not found and ye ye illegal ke bajay ka better way hai chizo ko handle karne ka .. aur error response par bhi btter bhi better control deta hai

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
