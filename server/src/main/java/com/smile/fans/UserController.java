package com.smile.fans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by agulshan on 09/09/17.
 */
@RestController("/login")
public class UserController {

    @Autowired
    private HttpServletRequest request;

    @GetMapping
    public String user(){
        return "logged in";
    }
}
