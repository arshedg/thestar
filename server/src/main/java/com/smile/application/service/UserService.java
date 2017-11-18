package com.smile.application.service;

import com.google.firebase.auth.FirebaseToken;
import com.smile.application.domain.User;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by agulshan on 16/11/17.
 */
public interface UserService {

    @Transactional(propagation = Propagation.REQUIRED)
    User userFromToken(FirebaseToken firebaseToken);

}
