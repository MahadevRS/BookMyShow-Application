package com.lostlife.BookMyShow.models;

import com.lostlife.BookMyShow.enums.SeatType;
import com.lostlife.BookMyShow.enums.ShowType;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.Format;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "shows")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate showDate;

    private LocalTime showTime;

    @Enumerated(value = EnumType.STRING)
    private ShowType showType;

    private Date dateCreatedOn;

    @ManyToOne
    @JoinColumn
    private Movie movie;

    @ManyToOne
    @JoinColumn
    private Theatre theatre;

    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    private List<ShowSeat> showSeatList=new ArrayList<>();

    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    private List<Ticket> listOfTickets=new ArrayList<>();

}
