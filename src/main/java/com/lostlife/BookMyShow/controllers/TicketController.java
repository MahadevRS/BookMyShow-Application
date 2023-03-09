package com.lostlife.BookMyShow.controllers;

import com.lostlife.BookMyShow.requestDTOs.TicketEntryDTO;
import com.lostlife.BookMyShow.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping("/book")
    public ResponseEntity bookTicket(@RequestBody TicketEntryDTO ticketEntryDto){

        try{
            String result = ticketService.addTicket(ticketEntryDto);
            return new ResponseEntity<>(result, HttpStatus.CREATED);

        }catch (Exception e){

            return new ResponseEntity<>("Ticket not booked",HttpStatus.BAD_REQUEST);
        }


    }
}
