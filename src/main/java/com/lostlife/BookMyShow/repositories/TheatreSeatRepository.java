package com.lostlife.BookMyShow.repositories;

import com.lostlife.BookMyShow.models.TheatreSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreSeatRepository extends JpaRepository<TheatreSeat,Integer> {
}
