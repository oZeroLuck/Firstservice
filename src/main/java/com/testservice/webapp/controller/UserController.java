package com.testservice.webapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.testservice.webapp.dto.UserDto;
import com.testservice.webapp.entity.WebUser;
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
    public WebUser getLogin(@PathVariable("username") String username) {
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
    public ResponseEntity<WebUser> createUser(@RequestBody WebUser webUser, BindingResult bindingResult) {
        WebUser checkWebUser = userService.getByIdAndUsername(webUser.getId(), webUser.getUsername());
        if (checkWebUser != null || bindingResult.hasErrors()) {
            System.out.println("WebUser Error");
        } else {
            userService.create(webUser);
        }
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {
        WebUser webUser = userService.getById(id);
        if (webUser == null) {
            System.out.println("Error");
        }

        userService.deleteUser(webUser);

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode responseNode = mapper.createObjectNode();

        responseNode.put("code", HttpStatus.OK.toString());
        responseNode.put("message", "Delete webUser " + id + " successfully executed");

        return new ResponseEntity<>(responseNode, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<WebUser> updateVehicle(@RequestBody WebUser webUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("Error");
        }
        WebUser checkWebUser = userService.getById(webUser.getId());
        if(checkWebUser != null) {
            System.out.println(webUser.getId());
            userService.update(webUser);
        }
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.CREATED);
    }

}
