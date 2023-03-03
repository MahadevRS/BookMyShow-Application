package com.lostlife.BookMyShow.models;

import com.lostlife.BookMyShow.enums.Genre;
import com.lostlife.BookMyShow.enums.Language;
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
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String movieName;

    private double rating;

    private int duration;

    @Enumerated(value = EnumType.STRING)
    private Language language;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL)
    private List<Show> listOfShows=new ArrayList<>();

}
