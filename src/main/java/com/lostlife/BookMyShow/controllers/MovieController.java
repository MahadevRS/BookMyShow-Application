package com.lostlife.BookMyShow.controllers;

import com.lostlife.BookMyShow.requestDTOs.MovieEntryDTO;
import com.lostlife.BookMyShow.services.MovieServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieServices movieServices;

    @PostMapping("/add")
    public ResponseEntity<String> addMovie(@RequestBody MovieEntryDTO movieEntryDTO){
        try{
            String result=movieServices.addMovie(movieEntryDTO);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }catch (Exception e){
            String response="Movie not added";
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
    }
}
