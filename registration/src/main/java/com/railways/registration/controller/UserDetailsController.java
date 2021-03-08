package com.railways.registration.controller;

import com.railways.registration.dto.UserDetailsResponseDTO;
import com.railways.registration.repository.UserRepository;
import com.railways.registration.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class UserDetailsController {
    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/userDetails")
    public UserDetailsResponseDTO getUserDetails(@RequestParam String userName){
        return userDetailsService.fetchUserDetails(userName);
    }
}
