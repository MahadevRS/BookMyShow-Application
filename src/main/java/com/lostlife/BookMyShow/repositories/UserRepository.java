package com.lostlife.BookMyShow.repositories;

import com.lostlife.BookMyShow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
