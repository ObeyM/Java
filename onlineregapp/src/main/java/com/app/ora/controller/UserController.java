package com.app.ora.controller;

import com.app.ora.dto.UserDto;
import com.app.ora.service.UserService;
import com.app.ora.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/application")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(Constants.GET_REGISTERED_USERS)
    public List<UserDto> getUserByRecordId() {

        return userService.getRegisteredUsers();
    }

    @RequestMapping(Constants.SAVE_USER)
    public boolean registerUser(@RequestBody UserDto userDto){

        return userService.registerUser(userDto);
    }
}