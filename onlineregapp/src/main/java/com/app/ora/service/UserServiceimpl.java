package com.app.ora.service;

import com.app.ora.entity.User;
import com.app.ora.mapper.UserMapper;
import com.app.ora.dto.UserDto;
import com.app.ora.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserServiceimpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto getUserByRecordId(String userIdNumber) {

        return UserMapper.entityToDto(userRepository.getOne(userIdNumber));
    }

    @Override
    public List<UserDto> getRegisteredUsers() {

        List<UserDto> userDtoList = new LinkedList<>();

        for (User user: userRepository.findAll()){

            userDtoList.add(UserMapper.entityToDto(user));
        }

        return userDtoList;
    }

    @Override
    public boolean registerUser(UserDto userDto) {

        boolean result = false;


        if (userRepository.checkDuplication(userDto.getUserIdNumber()) == null){

            userRepository.save(UserMapper.dtoToEntity(userDto));
            result = true;
        }

        return result;
    }
}