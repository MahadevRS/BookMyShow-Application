package com.lostlife.BookMyShow.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Theatre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String location;

    @OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL)
    private List<TheatreSeat> theatreSeats=new ArrayList<>();

    @OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL)
    private List<Show> theatreShows=new ArrayList<>();
}
