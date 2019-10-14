package com.app.ora.service;

import com.app.ora.entity.User;
import com.app.ora.mapper.UserMapper;
import com.app.ora.dto.UserDto;
import com.app.ora.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserServiceimpl implements UserService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceimpl.class);

    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserDto> getRegisteredUsers() {

        List<UserDto> userDtoList = new LinkedList<>();

        for (User user: userRepository.findAll()){

            userDtoList.add(UserMapper.entityToDto(user));
        }

        logger.debug("Found " + userDtoList.size() + " registered users.");

        return userDtoList;
    }

    @Override
    public boolean registerUser(UserDto userDto) {

        boolean result = false;

        logger.debug("Registering a user with full names -  " + userDto.getUserFullName() + ".");

        if (userRepository.checkDuplication(userDto.getUserIdNumber()) == null){

            userRepository.save(UserMapper.dtoToEntity(userDto));

            result = true;

            logger.debug("User registered successfully .");
        }

        return result;
    }
}