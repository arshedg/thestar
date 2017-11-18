package com.smile.application.security;

import java.util.concurrent.ExecutorService;
import java.util.function.Consumer;

import com.google.api.core.ApiFuture;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.auth.UserRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by agulshan on 12/11/17.
 */
@Component
public class AuthenticationService {

    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    private final ExecutorService executorService;

    @Autowired
    public AuthenticationService(@Qualifier("firebaseExecutorService") ExecutorService executorService) {
        this.executorService = executorService;
    }

    public void accessUserRecord( String uuid,Consumer<UserRecord> consumer,Consumer<Throwable> onFailure){
        ApiFuture<UserRecord> userRecordFuture = firebaseAuth.getUserAsync(uuid);
        FireBaseRunnable<UserRecord> runnable = new FireBaseRunnable(userRecordFuture,consumer, onFailure);
        userRecordFuture.addListener(runnable,executorService);
    }

    public void validateUser(String token,Consumer<FirebaseToken> onSuccess,Consumer<Throwable> onFailure){
        ApiFuture<FirebaseToken> firebaseTokenApiFuture = firebaseAuth.verifyIdTokenAsync(token);
        firebaseTokenApiFuture.addListener(new FireBaseRunnable(firebaseTokenApiFuture,onSuccess, onFailure),executorService);

    }
}





