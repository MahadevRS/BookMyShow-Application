package com.lostlife.BookMyShow.services;

import com.lostlife.BookMyShow.models.User;
import com.lostlife.BookMyShow.repositories.UserRepository;
import com.lostlife.BookMyShow.requestDTOs.UserEntryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void addUser(UserEntryDTO userEntryDTO) {

        User user = User.builder().name(userEntryDTO.getName()).age(userEntryDTO.getAge()).email(userEntryDTO.getEmail()).mobNo(userEntryDTO.getMobNo()).address(userEntryDTO.getAddress()).build();
        userRepository.save(user);
    }
}
