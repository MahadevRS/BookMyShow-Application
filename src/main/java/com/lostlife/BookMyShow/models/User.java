package com.lostlife.BookMyShow.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    private int age;

    @Column(unique = true,nullable = false)
    private String email;

    @Column(unique = true,nullable = false)
    private String mobNo;

    private String address;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Ticket> ticketsBooked =new ArrayList<>();

}
