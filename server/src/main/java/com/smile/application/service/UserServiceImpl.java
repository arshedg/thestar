package com.smile.application.service;

import java.util.Optional;

import com.google.firebase.auth.FirebaseToken;
import com.smile.application.domain.User;
import com.smile.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by agulshan on 16/11/17.
 */
@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User userFromToken(FirebaseToken firebaseToken) {
        String uuid = firebaseToken.getUid();
        Optional<User> user = userRepository.findById(uuid);
        if (!user.isPresent()) {
            User newUser = new User();
            newUser.setUuid(firebaseToken.getUid());
            newUser.setEmail(firebaseToken.getEmail());
            newUser.setDisplayName(firebaseToken.getName());
            newUser.setCurrencyType("Ruppee");
            newUser.setDisplayName(firebaseToken.getName());
            newUser.setCredits(0d);
            userRepository.saveAndFlush(newUser);
            return newUser;
        }
        return user.get();
    }

}

