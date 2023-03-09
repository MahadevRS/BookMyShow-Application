package com.lostlife.BookMyShow.controllers;

import com.lostlife.BookMyShow.requestDTOs.ShowEntryDTO;
import com.lostlife.BookMyShow.services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/show")
public class ShowController {

    @Autowired
    ShowService showService;

    @PostMapping("/add")
    public ResponseEntity<String> addShow(@RequestBody ShowEntryDTO showEntryDTO){

        try{
            String result=showService.addShow(showEntryDTO);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }catch (Exception e){
            String response="Show not added";
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }

    }
}
