package com.testservice.webapp.security;

import com.testservice.webapp.entity.WebUser;
import com.testservice.webapp.repository.UserRep;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class CustomUserDetailService implements UserDetailsService {
    private final UserRep userRep;

    public CustomUserDetailService(UserRep userRep) {
        this.userRep = userRep;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username == null || username.trim().isEmpty()) {
            throw new UsernameNotFoundException("WebUser not found");
        }
        WebUser webUser = userRep.getByUsername(username);
        if (webUser == null) {
            throw new UsernameNotFoundException("WebUser not found");
        }

        User.UserBuilder builder = User.withUsername(webUser.getUsername());
        builder.password(webUser.getPassword());
        if (webUser.getIsAdmin()) {
            builder.roles("ADMIN");
        } else {
            builder.roles("CUSTOMER");
        }

        return builder.build();
    }
}
