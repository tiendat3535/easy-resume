package com.dat.easyresumebackend.exception;

/**
 * Created by Pham Tien Dat on 05/11/2017.
 */
public class UserAlreadyExistsException extends Exception {

    public UserAlreadyExistsException(String username) {
        super("User with username: " + username + " already exists");
    }

}
