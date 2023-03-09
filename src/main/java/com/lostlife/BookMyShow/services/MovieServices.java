package com.lostlife.BookMyShow.services;

import com.lostlife.BookMyShow.Converters.MovieConverters;
import com.lostlife.BookMyShow.models.Movie;
import com.lostlife.BookMyShow.repositories.MovieRepository;
import com.lostlife.BookMyShow.requestDTOs.MovieEntryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServices {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(MovieEntryDTO movieEntryDTO) throws Exception{

        Movie movie= MovieConverters.convertEntryDtoToEntity(movieEntryDTO);
        movieRepository.save(movie);

        return "Movie Added successfully";
    }
}
