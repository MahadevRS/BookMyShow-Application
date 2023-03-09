package com.lostlife.BookMyShow.services;

import com.lostlife.BookMyShow.Converters.ShowConverters;
import com.lostlife.BookMyShow.enums.SeatType;
import com.lostlife.BookMyShow.models.*;
import com.lostlife.BookMyShow.repositories.MovieRepository;
import com.lostlife.BookMyShow.repositories.ShowRepository;
import com.lostlife.BookMyShow.repositories.TheatreRepository;
import com.lostlife.BookMyShow.requestDTOs.ShowEntryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheatreRepository theatreRepository;

    @Autowired
    ShowRepository showRepository;

    public String addShow(ShowEntryDTO showEntryDTO) {

        Show show= ShowConverters.convertEntryDtoToEntity(showEntryDTO);

        int movieId=showEntryDTO.getMovieId();
        int theatreID=showEntryDTO.getTheaterId();

        Movie movie=movieRepository.findById(movieId).get();
        Theatre theatre=theatreRepository.findById(theatreID).get();

        show.setMovie(movie);
        show.setTheatre(theatre);

        List<ShowSeat> showSeatList=createShowSeatEntity(showEntryDTO,show);

        show.setShowSeatList(showSeatList);

        show=showRepository.save(show);

        movie.getListOfShows().add(show);
        theatre.getTheatreShows().add(show);

        movieRepository.save(movie);
        theatreRepository.save(theatre);

        return "The show has been added successfully";
    }

    private List<ShowSeat> createShowSeatEntity(ShowEntryDTO showEntryDTO, Show show) {
        Theatre theatre=show.getTheatre();

        List<TheatreSeat> theatreSeats=theatre.getTheatreSeats();

        List<ShowSeat> showSeatList=new ArrayList<>();

        for(TheatreSeat theatreSeat:theatreSeats){
            ShowSeat showSeat=new ShowSeat();

            showSeat.setSeatNo(theatreSeat.getSeatNo());
            showSeat.setSeatType(theatreSeat.getSeatType());

            if(theatreSeat.getSeatType().equals(SeatType.CLASSIC)){
                showSeat.setPrice(showEntryDTO.getClassicSeatPrice());
            }else {
                showSeat.setPrice(showEntryDTO.getPremiumSeatPrice());
            }

            showSeat.setBooked(false);

            showSeat.setShow(show);

            showSeatList.add(showSeat);
        }

        return  showSeatList;
    }
}
