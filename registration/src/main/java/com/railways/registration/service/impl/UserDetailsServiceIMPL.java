package com.railways.registration.service.impl;

import com.railways.registration.dto.UserDetailsResponseDTO;
import com.railways.registration.entity.UserDetails;
import com.railways.registration.repository.UserRepository;
import com.railways.registration.service.UserDetailsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceIMPL implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetailsResponseDTO fetchUserDetails(String userName) {
        Optional<UserDetails> details = userRepository.findById(userName);
        if(details.isPresent()){
            UserDetails userDetails= details.get();
            UserDetailsResponseDTO responseDTO = new UserDetailsResponseDTO();
            responseDTO.setAge(userDetails.getAge());
            responseDTO.setEmail(userDetails.getEmail());
            responseDTO.setFname(userDetails.getFname());
             responseDTO.setLname(userDetails.getLname());
            responseDTO.setUserName(userDetails.getUserName());
            responseDTO.setMname(userDetails.getMname());
            responseDTO.setPhoneNumber(userDetails.getPhoneNumber());
            //BeanUtils.copyProperties(details,responseDTO);
            return responseDTO;
        }
        return null;
    }
}
