package com.lostlife.BookMyShow.controllers;

import com.lostlife.BookMyShow.requestDTOs.UserEntryDTO;
import com.lostlife.BookMyShow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody UserEntryDTO userEntryDTO){
        userService.addUser(userEntryDTO);
        return new ResponseEntity<>("Successfully added", HttpStatus.CREATED);
    }

}
