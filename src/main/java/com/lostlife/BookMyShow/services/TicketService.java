package com.lostlife.BookMyShow.services;

import com.lostlife.BookMyShow.Converters.TicketConverter;
import com.lostlife.BookMyShow.models.Show;
import com.lostlife.BookMyShow.models.ShowSeat;
import com.lostlife.BookMyShow.models.Ticket;
import com.lostlife.BookMyShow.models.User;
import com.lostlife.BookMyShow.repositories.ShowRepository;
import com.lostlife.BookMyShow.repositories.TicketRepository;
import com.lostlife.BookMyShow.repositories.UserRepository;
import com.lostlife.BookMyShow.requestDTOs.TicketEntryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    JavaMailSender javaMailSender;


    public String addTicket(TicketEntryDTO ticketEntryDto) throws Exception{

        Ticket ticket= TicketConverter.convertEntryDtoToEntity(ticketEntryDto);

        boolean isValidRequest=checkValidityofRequestedSeats(ticketEntryDto);

        if(!isValidRequest){
            throw new Exception("Requested seats are not available");
        }

        Show show=showRepository.findById(ticketEntryDto.getShowId()).get();
        List<ShowSeat> showSeatList=show.getShowSeatList();
        List<String> requestedSeats=ticketEntryDto.getRequestedSeats();

        int totalAmount=0;

        for(ShowSeat showSeat:showSeatList){
            if(requestedSeats.contains(showSeat.getSeatNo())){
                totalAmount=totalAmount+showSeat.getPrice();
                showSeat.setBooked(true);
                showSeat.setBookedAt(new Date());
            }
        }
        ticket.setAmount(totalAmount);

        ticket.setMovieName(show.getMovie().getMovieName());
        ticket.setShowDate(show.getShowDate());
        ticket.setShowTime(show.getShowTime());
        ticket.setTheatreName(show.getTheatre().getName());

        String allotedSeats=getAllotedSeatsfromShowSeats(requestedSeats);
        ticket.setBookedSeats(allotedSeats);

        User user=userRepository.findById(ticketEntryDto.getUserId()).get();

        ticket.setUser(user);
        ticket.setShow(show);

        ticket=ticketRepository.save(ticket);

        List<Ticket> ticketList=show.getListOfTickets();
        ticketList.add(ticket);
        show.setListOfTickets(ticketList);

        showRepository.save(show);

        List<Ticket> ticketList1=user.getTicketsBooked();
        ticketList1.add(ticket);
        user.setTicketsBooked(ticketList1);

        userRepository.save(user);

        String body = "Hi this is to confirm your booking for seat No "+allotedSeats +"for the movie : " + ticket.getMovieName();

        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setFrom("lostlifedeveloper@gmail.com");
        mimeMessageHelper.setTo(user.getEmail());
        mimeMessageHelper.setText(body);
        mimeMessageHelper.setSubject("Confirming your ticket");

        javaMailSender.send(mimeMessage);

        return "Ticket has successfully been booked";
    }

    private String getAllotedSeatsfromShowSeats(List<String> requestedSeats) {
        String result="";

        for(String seat:requestedSeats){
            result =result+seat+",";
        }
        return result;
    }

    private boolean checkValidityofRequestedSeats(TicketEntryDTO ticketEntryDto) {
        int showId = ticketEntryDto.getShowId();

        List<String> requestedSeats = ticketEntryDto.getRequestedSeats();

        Show show = showRepository.findById(showId).get();

        List<ShowSeat> listOfSeats = show.getShowSeatList();

        for(ShowSeat showSeat : listOfSeats){

            String seatNo = showSeat.getSeatNo();

            if(requestedSeats.contains(seatNo)){

                if(showSeat.isBooked()==true){
                    return false;
                }
            }
        }

        return true;
    }
}
