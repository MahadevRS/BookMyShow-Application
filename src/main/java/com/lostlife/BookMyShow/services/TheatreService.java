package com.lostlife.BookMyShow.services;

import com.lostlife.BookMyShow.Converters.TheatreConverters;
import com.lostlife.BookMyShow.enums.SeatType;
import com.lostlife.BookMyShow.models.Theatre;
import com.lostlife.BookMyShow.models.TheatreSeat;
import com.lostlife.BookMyShow.repositories.TheatreRepository;
import com.lostlife.BookMyShow.repositories.TheatreSeatRepository;
import com.lostlife.BookMyShow.requestDTOs.TheatreEntryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheatreService {

    @Autowired
    TheatreRepository theatreRepository;

    @Autowired
    TheatreSeatRepository theatreSeatRepository;


    public String addTheater (TheatreEntryDTO theatreEntryDTO) throws Exception{

        if(theatreEntryDTO.getName()==null || theatreEntryDTO.getLocation()==null ){
            throw new Exception("Name or Location invalid");
        }

        Theatre theatre= TheatreConverters.convertEntryDtoToEntity(theatreEntryDTO);
        List<TheatreSeat> theatreSeatList=createTheatreSeats(theatreEntryDTO,theatre);

        theatre.setTheatreSeats(theatreSeatList);
        theatreRepository.save(theatre);

        return "Theater Added successfully";
    }

    private List<TheatreSeat> createTheatreSeats(TheatreEntryDTO theatreEntryDTO, Theatre theatre) {

        int noOfClassicSeats=theatreEntryDTO.getClassicSeatsCount();
        int noOfPremiunSeats=theatreEntryDTO.getPremiumSeatsCount();

        List<TheatreSeat> theatreSeatList=new ArrayList<>();

        for(int i=1;i<=noOfClassicSeats;i++){
            TheatreSeat theatreSeat=TheatreSeat.builder().seatType(SeatType.CLASSIC)
                    .seatNo(i+"C").theatre(theatre).build();
            theatreSeatList.add(theatreSeat);
        }
        for(int i=1;i<=noOfPremiunSeats;i++){
            TheatreSeat theatreSeat=TheatreSeat.builder().seatType(SeatType.PREMIUM)
                    .seatNo(i+"P").theatre(theatre).build();

            theatreSeatList.add(theatreSeat);
        }

        return theatreSeatList;
    }
}
