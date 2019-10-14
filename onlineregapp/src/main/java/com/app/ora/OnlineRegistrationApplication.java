package com.app.ora;

import com.app.ora.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlineRegistrationApplication {

    static Logger logger = LoggerFactory.getLogger(OnlineRegistrationApplication.class);

    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {

        logger.debug("Starting APP...");

        SpringApplication.run(OnlineRegistrationApplication.class, args);
    }
}
