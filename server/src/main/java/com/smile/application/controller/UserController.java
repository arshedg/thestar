package com.smile.application.controller;

import java.util.concurrent.ExecutionException;

import com.google.firebase.auth.FirebaseToken;
import com.smile.application.domain.User;
import com.smile.application.repository.UserRepository;
import com.smile.application.security.AuthenticationService;
import com.smile.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * Created by agulshan on 09/09/17.
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final AuthenticationService authenticationService;
    private final UserService UserService;

    @Autowired
    public UserController(AuthenticationService authenticationService, UserService UserService) {
        this.authenticationService = authenticationService;
        this.UserService = UserService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String user(){
        return "user";
    }
    @RequestMapping(method = RequestMethod.POST)
    public DeferredResult authenticate(@RequestParam("token")String accessToken) throws ExecutionException, InterruptedException {
        DeferredResult result = new DeferredResult();
        authenticationService.validateUser(accessToken,
                token->result.setResult(UserService.userFromToken(token)),
                error->result.setErrorResult(error));
        return result;
    }

}
