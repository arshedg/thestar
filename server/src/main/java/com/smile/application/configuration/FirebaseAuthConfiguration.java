package com.smile.application.configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by agulshan on 12/11/17.
 */
@Component
public class FirebaseAuthConfiguration {

    @Bean
    @Qualifier("firebaseExecutorService")
    public ExecutorService threadPool(@Value("${firebase.threadpool.size}") Integer threadPoolSize){
        return Executors.newFixedThreadPool(threadPoolSize);
    }

}
