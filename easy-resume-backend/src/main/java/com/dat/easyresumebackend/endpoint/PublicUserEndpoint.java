package com.dat.easyresumebackend.endpoint;

import com.dat.easyresumebackend.domain.User;
import com.dat.easyresumebackend.dto.ErrorDto;
import com.dat.easyresumebackend.dto.UserDto;
import com.dat.easyresumebackend.exception.UserAlreadyExistsException;
import com.dat.easyresumebackend.mapper.UserDtoMapper;
import com.dat.easyresumebackend.mapper.UserMapper;
import com.dat.easyresumebackend.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.*;

/**
 * Created by Pham Tien Dat on 05/11/2017.
 */
@RestController
@RequestMapping("public")
public class PublicUserEndpoint {

    private static final Logger LOGGER = LoggerFactory.getLogger(PublicUserEndpoint.class);

    @Autowired
    private UserService userService;

    @PostMapping("user")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserDto userDto) {
        User registeredUser = null;
        try {
            userService.checkUserNotExistsByUsername(userDto.getUsername());
            registeredUser = userService.registerUser(UserDtoMapper.INSTANCE.toUser(userDto));
        } catch (UserAlreadyExistsException e) {
            LOGGER.error("User with username: " + userDto.getUsername() + " already exits", e);
            return ResponseEntity.badRequest().body(new ErrorDto(e.getClass().getSimpleName(), e.getMessage()));
        } catch (MessagingException e) {

        }
        return ResponseEntity.ok(UserMapper.INSTANCE.toUserDto(registeredUser));
    }

}
