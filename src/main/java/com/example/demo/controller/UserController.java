package com.example.demo.controller;

import com.example.demo.repository.UserProfileRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.model.RUser;
import com.example.demo.repository.model.RUserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserProfileRepository userProfileRepository;

    @RequestMapping("/toHello")
    public String toHello(){
        RUser user = userRepository.save(new RUser("Martin","123456","123456@foxmail.com"));
        userProfileRepository.save(new RUserProfile(user.getId(), "user"));
        List<?> result = userRepository.findUserDetail();
        System.out.println(userRepository.findUserDetail());
        return "helloBoot";
    }
}
