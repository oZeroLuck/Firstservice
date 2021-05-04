package com.testservice.webapp.controller;

import com.testservice.webapp.dto.AuthenticationInfoDto;
import com.testservice.webapp.service.AuthenticationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("http://localhost:4200")
public class AuthenticationController {

    private final AuthenticationService authService;

    public AuthenticationController(AuthenticationService authService) {
        this.authService = authService;
    }

    @GetMapping("/login/{username}")
    public AuthenticationInfoDto login(@PathVariable String username) {
        return authService.getUserInfo(username);
    }

}
