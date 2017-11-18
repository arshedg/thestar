package com.smile.application.security;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

import com.google.api.core.ApiFuture;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseCredentials;
import com.google.firebase.auth.UserRecord;

/**
 * Created by agulshan on 09/11/17.
 */
public class SecurityManager {

    public void initialize() throws IOException {
        InputStream keyFileStream = this.getClass().getClassLoader().getResourceAsStream("secret.json");
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredential(FirebaseCredentials.fromCertificate(keyFileStream))
                .setDatabaseUrl("https://celebrity-6faf6.firebaseio.com")
                .build();
        FirebaseApp.initializeApp(options);

    }

    public UserRecord getUserDetails(String uid) throws ExecutionException, InterruptedException {
        ApiFuture<UserRecord> userFuture = FirebaseAuth.getInstance().getUserAsync(uid);

        return null;
    }

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        SecurityManager sm = new SecurityManager();
        sm.initialize();
        sm.getUserDetails("jljt3bbFJPOd6m44kX8D6ziiabU2");
        Thread.sleep(100000);
        //System.out.println(sm.getUserDetails("jljt3bbFJPOd6m44kX8D6ziiabU2"));
    }


}

