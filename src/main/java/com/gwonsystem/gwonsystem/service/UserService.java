package com.gwonsystem.gwonsystem.service;

import com.gwonsystem.gwonsystem.entity.User;
import com.gwonsystem.gwonsystem.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void registerUser(String username, String password) {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 사용자 아이디입니다.");
        }

        User user = new User();
        user.setUsername(username);
        // 비밀번호를 암호화하여 저장
        user.setPassword(passwordEncoder.encode(password));
        user.setLoginStatus("logout"); // 초기 상태

        userRepository.save(user);
    }
}