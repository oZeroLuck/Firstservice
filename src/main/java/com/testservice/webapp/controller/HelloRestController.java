package com.testservice.webapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class HelloRestController {

    @GetMapping(value = "/test")
    public String getGreeting() {
        return ("Hello world!");
    }

    @GetMapping(value = "/hello/{name}")
    public String getGreeting2(@PathVariable("name") String name) {
        if (name.equals("Sara")) {
            throw new RuntimeException("You're not welcome Sara");
        }
        return String.format("\"Hello %s, I'm a restful service!\"", name);
    }
}
