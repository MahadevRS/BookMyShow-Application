package com.lostlife.BookMyShow.Converters;

import com.lostlife.BookMyShow.models.Ticket;
import com.lostlife.BookMyShow.requestDTOs.TheatreEntryDTO;
import com.lostlife.BookMyShow.requestDTOs.TicketEntryDTO;

public class TicketConverter {

    public static Ticket convertEntryDtoToEntity (TicketEntryDTO ticketEntryDTO){
        Ticket ticket=new Ticket();
        return ticket;
    }
}
