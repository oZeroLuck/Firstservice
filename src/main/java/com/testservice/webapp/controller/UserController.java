package com.testservice.webapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.testservice.webapp.dto.UserDto;
import com.testservice.webapp.entity.User;
import com.testservice.webapp.service.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // TODO: Change login method
    @GetMapping("/login/{username}")
    public User getLogin(@PathVariable("username") String username) {
        return userService.getByUsername(username);
    }

    @GetMapping("/get/all")
    public List<UserDto> getCustomers() {
        return userService.getAllUsers();
    }

    @GetMapping("/get/{userId}")
    public UserDto getUser(@PathVariable("userId") int userId) {
        return userService.getDtoById(userId);
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user, BindingResult bindingResult) {
        User checkUser = userService.getByIdAndUsername(user.getId(), user.getUsername());
        if (checkUser != null || bindingResult.hasErrors()) {
            System.out.println("User Error");
        } else {
            userService.create(user);
        }
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {
        User user = userService.getById(id);
        if (user == null) {
            System.out.println("Error");
        }

        userService.deleteUser(user);

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode responseNode = mapper.createObjectNode();

        responseNode.put("code", HttpStatus.OK.toString());
        responseNode.put("message", "Delete user " + id + " successfully executed");

        return new ResponseEntity<>(responseNode, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<User> updateVehicle(@RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("Error");
        }
        User checkUser = userService.getById(user.getId());
        if(checkUser != null) {
            System.out.println(user.getId());
            userService.update(user);
        }
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.CREATED);
    }

}
