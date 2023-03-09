package com.lostlife.BookMyShow.requestDTOs;

import com.lostlife.BookMyShow.enums.Genre;
import com.lostlife.BookMyShow.enums.Language;
import lombok.Data;

@Data
public class MovieEntryDTO {
    private String movieName;

    private double ratings;

    private int duration;

    private Language language;

    private Genre genre;
}
