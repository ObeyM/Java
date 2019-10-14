package com.app.ora.mapper;

import com.app.ora.dto.UserDto;
import com.app.ora.entity.User;

import java.util.Date;

public class UserMapper {

    public static User dtoToEntity(UserDto userDto) {

        User user = new User();
        user.setUserRecordId(System.currentTimeMillis());
        user.setUserFullName(userDto.getUserFullName());
        user.setUserIdNumber(userDto.getUserIdNumber());
        user.setDateRegistered(new Date());

        return user;
    }

    public static UserDto entityToDto(User user) {

        UserDto userDto = new UserDto();
        userDto.setUserRecordId(user.getUserRecordId());
        userDto.setUserFullName(user.getUserFullName());
        userDto.setUserIdNumber(user.getUserIdNumber());
        userDto.setDateRegistered(user.getDateRegistered());

        return userDto;
    }
}