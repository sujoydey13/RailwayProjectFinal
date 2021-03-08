package com.railways.registration.service;

import com.railways.registration.dto.UserDetailsResponseDTO;

public interface UserDetailsService {
    UserDetailsResponseDTO fetchUserDetails(String userName);
}
