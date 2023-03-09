package com.lostlife.BookMyShow.Converters;

import com.lostlife.BookMyShow.models.Ticket;
import com.lostlife.BookMyShow.requestDTOs.TheatreEntryDTO;

public class TicketConverter {

    public static Ticket convertEntryDtoToEntity (TheatreEntryDTO theatreEntryDTO){
        Ticket ticket=new Ticket();
        return ticket;
    }
}
