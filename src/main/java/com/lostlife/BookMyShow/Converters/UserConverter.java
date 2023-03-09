package com.lostlife.BookMyShow.Converters;

import com.lostlife.BookMyShow.models.User;
import com.lostlife.BookMyShow.requestDTOs.UserEntryDTO;

public class UserConverter {

    public static User convertEntryDtoToEntity(UserEntryDTO userEntryDTO){

        User user=User.builder()
                .age(userEntryDTO.getAge())
                .address(userEntryDTO.getAddress())
                .email(userEntryDTO.getEmail())
                .name(userEntryDTO.getName())
                .mobNo(userEntryDTO.getMobNo())
                .build();

        return user;
    }
}
