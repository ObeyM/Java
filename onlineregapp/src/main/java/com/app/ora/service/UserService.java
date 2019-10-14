package com.app.ora.service;


import com.app.ora.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getRegisteredUsers();

    boolean registerUser(UserDto userDto);
}