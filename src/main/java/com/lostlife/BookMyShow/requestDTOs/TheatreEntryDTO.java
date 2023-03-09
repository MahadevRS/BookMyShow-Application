package com.lostlife.BookMyShow.requestDTOs;

import lombok.Data;

@Data
public class TheatreEntryDTO {
    private String name;
    private String location;

    private int classicSeatsCount;

    private int premiumSeatsCount;
}
