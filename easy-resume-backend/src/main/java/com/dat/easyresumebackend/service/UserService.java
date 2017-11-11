package com.dat.easyresumebackend.service;

import com.dat.easyresumebackend.domain.User;
import com.dat.easyresumebackend.exception.UserAlreadyExistsException;

import javax.mail.MessagingException;

/**
 * Created by Pham Tien Dat on 05/11/2017.
 */
public interface UserService {
    void checkUserNotExistsByUsername(String username) throws UserAlreadyExistsException;
    User registerUser(User user) throws MessagingException;
}
