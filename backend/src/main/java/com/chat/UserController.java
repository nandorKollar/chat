package com.chat;

import com.chat.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/online")
    public void online() {
        String username = ((org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        userRepository.setOnline(username, true);
    }

    @RequestMapping("/offline")
    public void offline() {
        String username = ((org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        userRepository.setOnline(username, false);
    }

    @RequestMapping("/all")
    public Iterable<User> listUsers() {
        return userRepository.findAll();
    }
}
