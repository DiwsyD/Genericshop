package com.stepit.lecture.genericshop.user.service;

import com.stepit.lecture.genericshop.user.entity.Role;
import com.stepit.lecture.genericshop.user.entity.User;
import com.stepit.lecture.genericshop.user.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getUser(String email) {
        return userRepository.findByEmail(email)
                .orElse(
                        User.builder()
                                .role(Role.UNKNOWN)
                                .build()
                );
    }


}
