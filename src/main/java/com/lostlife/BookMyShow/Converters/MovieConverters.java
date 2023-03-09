package com.lostlife.BookMyShow.Converters;

import com.lostlife.BookMyShow.models.Movie;
import com.lostlife.BookMyShow.requestDTOs.MovieEntryDTO;

public class MovieConverters {

    public static Movie convertEntryDtoToEntity(MovieEntryDTO movieEntryDTO){
        Movie movie=Movie.builder().movieName(movieEntryDTO.getMovieName()).duration(movieEntryDTO.getDuration())
                .genre(movieEntryDTO.getGenre()).language(movieEntryDTO.getLanguage())
                .rating(movieEntryDTO.getRatings()).build();

        return movie;
    }
}
