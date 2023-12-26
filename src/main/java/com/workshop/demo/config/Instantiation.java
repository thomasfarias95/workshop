package com.workshop.demo.config;

import com.workshop.demo.domain.User;
import com.workshop.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

import static java.util.Arrays.asList;

@Configuration
public class Instantiation implements CommandLineRunner {
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public void run(String... args) throws Exception {
        
        userRepository.deleteAll();
        
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Gray", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, bob, alex));
    }
}
