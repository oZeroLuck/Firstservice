package com.testservice.webapp.security;

import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AuthEntryPoint extends BasicAuthenticationEntryPoint {
    private static String REALM = "REALM";

    public void commence(final HttpServletRequest request,
                         final HttpServletResponse response,
                         final AuthenticationException authException) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.addHeader("WWW-Authenticate", "Basic Realm= " +getRealmName());

        PrintWriter writer = response.getWriter();
        writer.println("UserId Or Password are wrong");
    }

    @Override
    public void afterPropertiesSet() {
        setRealmName(REALM);
        super.afterPropertiesSet();
    }
}
