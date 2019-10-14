package com.app.ora;

import com.app.ora.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlineRegistrationApplication {

    Logger logger = LoggerFactory.getLogger(OnlineRegistrationApplication.class);

    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {

        System.out.println("Starting APP...");

        SpringApplication.run(OnlineRegistrationApplication.class, args);
    }
}
