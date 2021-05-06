package com.testservice.webapp.controller;

import com.testservice.webapp.dto.JwtResponse;
import com.testservice.webapp.dto.LoginRequest;
import com.testservice.webapp.dto.RegisterRequest;
import com.testservice.webapp.entity.WebUser;
import com.testservice.webapp.security.JwtTokenUtil;
import com.testservice.webapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final UserService userService;
    private final JwtTokenUtil jwtTokenUtil;
    private final AuthenticationManager authManager;

    public AuthenticationController(UserService userService,
                                    JwtTokenUtil jwtTokenUtil,
                                    AuthenticationManager authManager) {
        this.userService = userService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.authManager = authManager;
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenUtil.generateJwtToken(authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        // Temporary patch
        WebUser webUser = userService.getByUsername(userDetails.getUsername());
        List<String> role = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                                                 webUser.getId(),
                                                 userDetails.getUsername(),
                                                 role.get(0)));

    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest request) {
        if (userService.existByEmail(request.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Username is already taken!");
        }

        if (userService.existByEmail(request.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Email is already registered");
        }

        WebUser webUser = new WebUser(request);

        userService.create(webUser);

        return ResponseEntity.ok("Success: User has been registered");
    }
}


