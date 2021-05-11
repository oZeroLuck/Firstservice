package com.testservice.webapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.testservice.webapp.dto.PassRequest;
import com.testservice.webapp.dto.UserDto;
import com.testservice.webapp.entity.WebUser;
import com.testservice.webapp.service.UserService;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get/all")
    public List<UserDto> getCustomers() {
        return userService.getAllUsers();
    }

    @GetMapping("/get/{userId}")
    public UserDto getUser(@PathVariable("userId") int userId) {
        UserDto user = userService.getDtoById(userId);
        System.out.println(user.getBirthDate());
        return userService.getDtoById(userId);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@Valid @RequestBody WebUser webUser, BindingResult bindingResult) {
        WebUser checkWebUser = userService.getByIdAndUsername(webUser.getId(), webUser.getUsername());
        if (checkWebUser != null || bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        } else {
            userService.create(webUser);
            return new ResponseEntity<>(new HttpHeaders(), HttpStatus.CREATED);
        }
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
    public ResponseEntity<WebUser> updateVehicle(@Valid @RequestBody WebUser webUser,
                                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("Error");
        }
        WebUser checkWebUser = userService.getById(webUser.getId());
        if(checkWebUser != null) {
            if(webUser.getIsAdmin()) {
                webUser.setIsAdmin(true);
            }
            userService.update(webUser);
        }
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.CREATED);
    }

    @PutMapping("/update/password")
    public ResponseEntity<PassRequest> updatePassword(@Valid @RequestBody PassRequest req,
                                                      BindingResult bindingResult) {
        if(userService.updatePassword(req) && !bindingResult.hasErrors()) {
            return new ResponseEntity<>(new HttpHeaders(), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
    }

}
