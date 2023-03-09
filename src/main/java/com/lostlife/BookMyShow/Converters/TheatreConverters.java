package com.lostlife.BookMyShow.Converters;

import com.lostlife.BookMyShow.models.Theatre;
import com.lostlife.BookMyShow.requestDTOs.TheatreEntryDTO;

public class TheatreConverters {

    public static Theatre convertEntryDtoToEntity(TheatreEntryDTO theatreEntryDTO){
        Theatre theatre=Theatre.builder()
                .name(theatreEntryDTO.getName())
                .location(theatreEntryDTO.getLocation()).build();

        return theatre;
    }
}
